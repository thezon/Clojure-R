(ns poc.protocolpoc)

(defn internal-R-struct [operation parms-vec]
  {:R-struct true :oper operation :parms parms-vec})

(defprotocol prot-R-command
     (create-data-struct [_])
     (emit-exicute-code [_]))

(defn R->generate-command [R-rep]
  "Mapping of clojure R representation to R language"
  (let [struct (create-data-struct R-rep)]
    (emit-exicute-code 
      (apply (resolve (symbol (name (:oper struct))))
             (for [entry (:parms struct)]
               (cond 
                 (.contains (str (class entry)) "reify") (R->generate-command entry) ; bad way to check condition
                 (seq? entry) (apply R->generate-command entry) ;ignore unintitional seq wraps
                 :default  entry))))))

(defn R->def [var value]
     (reify
       prot-R-command
       (create-data-struct [_]
         (internal-R-struct :R->def [var value]))
       (emit-exicute-code [_]
         (str (name var) "<-" value))))

(defn R->= [var value]
     (reify
       prot-R-command
       (create-data-struct [_]
         (internal-R-struct :R->= [var value]))
       (emit-exicute-code [_]
         (str (name var) "=" value))))

(defn R->vector [& values]
  "Takes vector, R-vector, numbers or attribute map"
  (reify 
    prot-R-command
    (create-data-struct [_]
     (internal-R-struct :R->vector [(into [] values)]))
    (emit-exicute-code [_]
      (str (reduce str "c("  (interpose "," values)) ")"))))

(defn R->mean [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (reify 
    prot-R-command
    (create-data-struct [_]
      (internal-R-struct :R->mean
                         (cond          
                           (> (count data) 1)            [(apply R->vector data)]
                           (apply vector? data)          [(apply R->vector (first data))]
                           (and (apply map? data)
                                (apply :R-struct data))  [(first data)]
                           (apply map? data)             (into [] (->> data  (apply seq) (map (fn [val] (R->= (first val) (second val))))))
                           :default                      (throw (Exception. "Invalid element in function R->Mean.")))))
    (emit-exicute-code [_]
      (str "mean(" (apply str (interpose "," data)) ")"))))