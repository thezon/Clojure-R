(ns dsl.dsl-mean
  (:require [support.RC-support :as sup]
            [transformation.R-struct-gen :as R]))



(defn mean-simple [& data] 
  "Gets mean of data, data can be numbers, vector, set or r-vector"
    (cond
      (not (coll? (first data)))
      (R/R->mean 
       (apply R/R->vector (map R/R->raw data)))
      (or (vector? (first data)) (set? (first data)))
      (R/R->mean 
        (apply R/R->vector (map R/R->raw (first data))))
      (:R-struct (first data))
      (R/R->mean (first data))
      :default
      (throw (Exception. (str "Invalid data type to mean")))))
  
(defn mean-configured [attribute-map]
  (apply R/R->mean 
         (map (fn [v] 
                (R/R->= (R/R->raw (name (first v)))
                        (if (coll? (second v))
                        (second v)
                        (R/R->raw  (second v))))) attribute-map)))
