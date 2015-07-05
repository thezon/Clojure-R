(ns support.RC-support
  (:require [dsl.primary-operations :as dsl]))
  
(defn stnd-input-support 
  ([^clojure.lang.ArraySeq data]
    (stnd-input-support data [:num :vec :map :r-str]))
  ([^clojure.lang.ArraySeq data options-vec]
    ":num allow numbers
     :vec allows vectors
     :map allows maps
     :r-str allow R structure"
    (cond          
      (and 
        (> (count data) 1)
        (some #{:num} options-vec))    [(apply dsl/R->vector data)]
      (and 
        (apply vector? data) 
        (some #{:vec} options-vec))    [(apply dsl/R->vector (first data))]
      (and 
        (apply map? data)
        (apply :R-struct data)
        (some #{:r-str} options-vec))  [(first data)]
      (and 
        (apply map? data) 
        (some #{:map} options-vec))    (into [] (->> data  (apply seq) (map (fn [val] (dsl/R->= (first val) (second val))))))
      :default                         (throw (Exception. "Invalid element in function R->summary.")))))

