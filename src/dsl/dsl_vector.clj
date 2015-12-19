(ns dsl.dsl-vector
  (:require [codeGeneration.base-operators :as R]))

(defn vector-simple [& values]
  (apply R/R->vector (map R/R->raw values)))

;(defn vector-complex [& values]
;  (apply R/R->vector (map R/R->raw values)))
