(ns dsl.dsl-matrix
  (:require [support.RC-support :as sup]
            [transformation.R-struct-gen :as R]))

(defn matrix-simple [num-row num-col data-vec]
  "Creates a matrix with num-rows, num-cols and data as vector, set or R vector"
  (R/R->matrix
    (R/R->= (R/R->raw "nrow") (R/R->raw num-row))
    (R/R->= (R/R->raw "ncol") (R/R->raw  num-col))
    (R/R->= 
      (R/R->raw "data") 
      (cond 
        (or (vector? data-vec) (set? data-vec)) 
        (apply R/R->vector (map R/R->raw data-vec))
        (:R-struct data-vec) 
        data-vec
        :default
        (throw (Exception. (str "Invalid data type to matrix")))))))

(defn matrix-configured [attribute-map]
  (apply R/R->matrix 
         (map (fn [v] (R/R->= (R/R->raw (name (first v)))
                              (if (coll? (second v))
                                (second v)
                                (R/R->raw  (second v))))) attribute-map)))

