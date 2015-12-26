(ns dsl.dsl-dataframe
  (:require [support.RC-support :as sup]
            [transformation.R-struct-gen :as R]))

(defn R->dataframe-vec [& vectors]
  "takes clojure vectors or sets and creates a dataframe"
   (apply transformation.R-struct-gen/R->dataframe 
     (for [a-vec vectors]
       (apply transformation.R-struct-gen/R->vector 
         (map transformation.R-struct-gen/R->raw a-vec)))))

(defn R->dataframe-variables [& vectors]
  "takes R vectors and creates a dataframe"
   (apply transformation.R-struct-gen/R->dataframe vectors))
      