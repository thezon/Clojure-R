(ns support.RC-support
  (:require [transformation.R-thin-client :as dsl]))


(defmacro r-funct-dispatch [name]
  (let [name-var (gensym)]
  `(defmulti ~name (fn[& ~name-var]
                     (cond 
                       (and (map? (first ~name-var)) (not (:r-struct (first ~name-var))))
                       :map
                       (reduce #(= %1 (not (coll? %2))) true ~name-var)
                       :raw
                       (string? (first ~name-var))
                       :str
                       (vector? (first ~name-var))
                       :vec
                       (:r-struct (first ~name-var))
                       :r-struct
                       :default
                       :error)))))


