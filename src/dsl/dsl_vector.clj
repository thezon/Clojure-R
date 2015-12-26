(ns dsl.dsl-vector
  (:require [support.RC-support :as sup]
            [transformation.R-struct-gen :as R]))

(defn R->vector-simple [& values]
  (if  (coll? (first values))
    (apply R/R->vector (map R/R->raw (first values)))
    (apply R/R->vector (map R/R->raw values))))

;(defn vector-complex [& values]
;  (apply R/R->vector (map R/R->raw values)))
