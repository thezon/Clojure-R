(ns codeGeneration.RC-code-generation)

(defn gen-R->def [var-name value]
  (str (name var-name) "<-" value))

(defn gen-R->= [var-name value]
  (str (name var-name) "=" value))

(defn gen-R->vector [values]
  (str (reduce str "c("  (interpose "," values)) ")"))

(defn gen-R->range [low-val high-val]
  (str "(" low-val ":" high-val ")"))

(defn gen-R->slurp [path]
  (str "read.table(\"" path "\")"))

(defn gen-R->mean [& data]
     (str "mean(" (apply str (interpose "," data)) ")"))

(defn gen-R->dataframe [& data]
     (str "data.frame(" (apply str (interpose "," data)) ")"))

(defn gen-R-post-proc [& data]
  (apply str (interpose ";" data)))

(defn gen-R->summary [& data]
     (str "summary(" (apply str (interpose "," data)) ")"))

(defn gen-R-post-proc [data]
  (apply str (interpose ";" data)))

(defn gen-R-struct [operation parms-vec]
  {:R-struct true :oper operation :parms parms-vec})

(defn gen-R->dataframe? [& data]
  (str "is.data.frame(" (apply str (interpose "," data)) ")"))

(defn gen-R->vector? [data]
  (str "is.vector(" data ")"))

(defn gen-R->rownames [data]
  (str "row.names(" data ")"))

(defn gen-R->matrix [& data]
  (str "matrix(" (apply str (interpose "," data)) ")"))

(defn R->generate-command [R-rep]
  "Mapping of clojure R representation to R language"
  (apply 
    (resolve (symbol (str "codeGeneration.RC-code-generation/gen-" (name (:oper R-rep)))))
    (for [entry (:parms R-rep)]
      (cond 
        (map? entry) (R->generate-command entry)
        (seq? entry) (apply R->generate-command entry) 
        :default  entry))))

(defn R->generate [& R-rep]
  "Mapping of clojure R representation to R language"
  (->> R-rep (map R->generate-command) gen-R-post-proc ))
