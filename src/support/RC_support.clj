(ns support.RC-support
  (:require [dsl.primary-operations :as dsl]))

(def verbose false)

(defn convert-raw-value [data-coll]
  "Converts raw numbers and keywords to R datastructs"
  (into []
        (map (fn [x] (cond
                       (number? x) (dsl/R->number x)
                       (keyword? x) (dsl/R->keyword x)
                       :default (throw (Exception. (str "Invalid parameter type in function."))))) data-coll)))

(defn verbose-print [type data]
  (if verbose
    (println "processing: " type "  data: " data)))

;this needs to be broken into smaller functions
(defn stnd-input-support 
  "Resolves common parameter input conversions such and numbers vectors and maps"
  ([^clojure.lang.ArraySeq data]
    (stnd-input-support data [:raw :vec :map :r-str]))
  ([^clojure.lang.ArraySeq data options-vec]
    ":num allow numbers
     :vec allows vectors
     :map allows maps
     :r-str allow R structure"
    (let [cardinality (count data)]
      (cond          
        (and 
          (some #{:raw} options-vec)
          (> cardinality 1)) 
        (do 
          (verbose-print :raw  data) 
          [(apply dsl/R->vector (convert-raw-value data))])
        (and 
          (some #{:vec} options-vec)
          (= cardinality 1)
          (apply vector? data))    
        (do 
          (verbose-print :vec  data) 
          [(apply dsl/R->vector (convert-raw-value (first data)))])
        (and 
          (some #{:r-str} options-vec)
          (= cardinality 1)
          (apply map? data)
          (apply :R-struct data)) 
        (do 
          (verbose-print :r-str  data) 
          [(-> data first (assoc  :parms (->> data (apply :parms) (convert-raw-value))))])
        (and 
          (some #{:map} options-vec)
          (= cardinality 1)
          (apply map? data))    
        (do 
          (verbose-print :map  data)
          (into [] 
                (->> data  (apply seq)
                  (map (fn [val] (dsl/R->= (dsl/R->keyword (first val)) (second val)))))))
        :default                       
        (throw (Exception. "Invalid element in function R->summary."))))))

