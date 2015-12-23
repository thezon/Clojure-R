(ns rc.core)


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
    '[transformation.R-struct-gen]
    ;'[transformation.R-thin-client :as tc]
    ))

(force-dep-reload)

(defn clojure-R-transform [clojure-string]
  (do (force-dep-reload)
    (R->generate
      (eval
        (read-string clojure-string)))))

;use this for convient repl sandbox



