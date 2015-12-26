(ns dsl.dsl-histogram
  (:require [support.RC-support :as sup]
            [transformation.R-struct-gen :as R]))

(defn R->histogram-attributes [attribute-map]
  (apply R/R->histogram 
         (map (fn [v] 
                (R/R->= (R/R->raw (name (first v)))
                        (if (coll? (second v))
                        (second v)
                        (R/R->raw  (second v))))) attribute-map)))
