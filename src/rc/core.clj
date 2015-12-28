(ns rc.core
  (:require [clojure.tools.logging :as log]))


;seperated from ns as not generating correctly
(defn force-dep-reload []
  (use 
    '[transformation.code-generation]
    '[dsl.dsl-mean]
    '[dsl.dsl-matrix]
    '[dsl.dsl-vector]
    '[dsl.dsl-boxplot]
    '[dsl.dsl-dotchart]
    '[dsl.dsl-dataframe]
    ;'[transformation.R-struct-gen]
    '[dsl.dsl-R-core]))

(force-dep-reload)

(defn condition-string [in-str]
  (clojure.string/replace
    (clojure.string/replace
      (clojure.string/replace in-str #"(?<!#)\((?!\()" "(R->")
      #"#\(" "(")
  #"##\(" "#("))

(defn clojure-R-transform [clojure-string]
  (do (force-dep-reload)
    (try 
      (R->generate
        (eval
          (read-string (condition-string clojure-string))))
      (catch Exception ex
        (do (clojure.tools.logging/error "Generation Error" ex)
        (str "Error: " ex ))))))



