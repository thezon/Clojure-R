(ns transformation.code-generation
  (:require [clojure.tools.logging :as log]))

; these functions take input of a R data structure and converts to a r command string


(defn gen-R-post-proc [& data]
  (apply str (interpose ";" data)))

(defn R->generate-command [R-rep]
  "Mapping of clojure R representation to R language
   Only accepts R-structs and vectors of R-structs"
  (apply 
     (resolve 
        (symbol (str "transformation.R-thin-client/" (name (:oper R-rep))))); get code emittion function
      (for [entry (:parms R-rep)] ; process each parameter
        (cond 
          (:raw R-rep) ;raw data is end of processing for branch
          entry
          (and (map? entry) (:R-struct entry)) ;process R struct
          (R->generate-command entry) 
          (vector? entry) ;process list of R struct
          (map R->generate-command entry)
          :default  ;malformed input
          (throw (Exception. (str "Generator must only contain vectors and R-structs\nfound: " entry "\n")))))))

(defn R->generate [& R-rep]
  "Mapping of clojure R representation to R language"
  (try
    (log/spy :info (apply str (map (fn [x](str (R->generate-command x) ";")) R-rep)))
    (catch Exception ex
      (log/error ex "Error in transformation."))))
  