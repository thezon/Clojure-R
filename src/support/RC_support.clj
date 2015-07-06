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
    (let [cardinality (count data)]
    (cond          
      (and 
        (some #{:num} options-vec)
        (> cardinality 1)) [(apply dsl/R->vector data)]
      (and 
        (some #{:vec} options-vec)
        (= cardinality 1)
        (apply vector? data))    [(apply dsl/R->vector (first data))]
      (and 
        (some #{:r-str} options-vec)
        (= cardinality 1)
        (apply map? data)
        (apply :R-struct data))  [(first data)]
      (and 
        (some #{:map} options-vec)
        (= cardinality 1)
        (apply map? data))    (into [] (->> data  (apply seq) (map (fn [val] (dsl/R->= (first val) (second val))))))
      :default                         (throw (Exception. "Invalid element in function R->summary."))))))

