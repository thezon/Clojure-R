(ns support.RC-support
  (:require [dsl.primary-operations :as dsl]))
  
(defn stnd-input-support [^clojure.lang.ArraySeq data]
  (cond          
    (> (count data) 1)            [(apply dsl/R->vector data)]
    (apply vector? data)          [(apply dsl/R->vector (first data))]
    (and (apply map? data)
         (apply :R-struct data))  [(first data)]
    (apply map? data)             (into [] (->> data  (apply seq) (map (fn [val] (dsl/R->= (first val) (second val))))))
    :default                      (throw (Exception. "Invalid element in function R->summary."))))