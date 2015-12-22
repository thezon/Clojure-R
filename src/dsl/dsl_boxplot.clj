(ns dsl.dsl-boxplot
  (:require [support.RC-support :as sup]
            [transformation.R-struct-gen :as R]))

(defn boxplot-attributes [attribute-map]
  (apply R/R->boxplot 
         (map (fn [v] 
                (R/R->= (R/R->raw (name (first v)))
                        (if (coll? (second v))
                        (second v)
                        (R/R->raw  (second v))))) attribute-map)))

