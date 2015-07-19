(ns dsl.primary-operations
  (:require [codeGeneration.RC-code-generation :as gen]))

;The porpose of these is to create the correct represent datastructure 
;There is little benifit for user to directly work with this

(defn R->mean [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->mean (into [] data)))

(defn R->summary [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->summary (into [] data)))

(defn R->dataframe [& data]
  "attribute map"
  (gen/gen-R-struct :R->dataframe  (into [] data)))

(defn R->matrix [& data]
  "attribute map"
  (gen/gen-R-struct :R->matrix (into [] data)))

(defn R->stripchart [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->stripchart  (into [] data)))

(defn R->histogram [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->histogram (into [] data)))

(defn R->boxplot [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->boxplot (into [] data)))

(defn R->sample [& data]
  "Takes numbers or key"
  (gen/gen-R-struct :R->sample (into [] data)))

(defn R->number [val]
  (gen/gen-R-struct :R->number [val]))

(defn R->keyword [val]
  (gen/gen-R-struct :R->keyword [(name val)]))

(defn R->def [var-name value]
  (gen/gen-R-struct :R->def [(name var-name) value]))

(defn R->vector [& data]
  (gen/gen-R-struct :R->vector (into [] data)))

(defn R->= [var-name value]
  (gen/gen-R-struct :R->= [(name var-name) value]))

(defn R->vector [& data]
  (gen/gen-R-struct :R->vector (into [] data)))

(defn R->range [low-val high-val]
  (gen/gen-R-struct :R->range  [low-val high-val]))

(defn R->slurp [path]
  (gen/gen-R-struct :R->slurp [path]))

(defn R->dataframe? [var]
  (gen/gen-R-struct :R->dataframe? [(name var)]))

(defn R->vector? [var]
  (gen/gen-R-struct :R->vector? [(name var)]))

(defn R->rownames [var]
  (gen/gen-R-struct :R->rownames? [(name var)]))