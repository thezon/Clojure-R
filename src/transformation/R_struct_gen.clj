(ns transformation.R-struct-gen
  (:require [transformation.code-generation :as gen]))

;The purpose of these functions is to create representitive datastructure 
;These functions are verbose and normally should not be used by users
;parameter inputs are not transformed only added to the datastructure

;needs to be removed
(defn gen-R-struct [operation parms-vec]
  {:R-struct true :oper operation :parms parms-vec})

(defn R->raw [data]
  (assoc (gen-R-struct :R->raw [data]) :raw true))

(defn R->empty []
  (assoc (gen-R-struct :R->raw [""]) :raw true))

(defn R->mean [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen-R-struct :R->mean (into [] data)))

(defn R->summary [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen-R-struct :R->summary (into [] data)))

(defn R->dataframe [& data]
  "attribute map"
  (gen-R-struct :R->dataframe  (into [] data)))

(defn R->matrix [& data]
  "attribute map"
  (gen-R-struct :R->matrix (into [] data)))

(defn R->array [& data]
  "attribute map"
  (gen-R-struct :R->matrix (into [] data)))

(defn R->stripchart [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen-R-struct :R->stripchart  (into [] data)))

(defn R->histogram [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen-R-struct :R->histogram (into [] data)))

(defn R->boxplot [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen-R-struct :R->boxplot (into [] data)))

(defn R->dotchart [& data]
  (gen-R-struct :R->dotchart (into [] data)))

(defn R->sample [& data]
  "Takes numbers or key"
  (gen-R-struct :R->sample (into [] data)))

(defn R->number [val]
  (gen-R-struct :R->number [val]))

(defn R->keyword [val]
  (gen-R-struct :R->keyword [(name val)]))

(defn R->def [var-name value]
  (gen-R-struct :R->def [(name var-name) value]))

(defn R->vector [& data]
  (gen-R-struct :R->vector (into [] data)))

(defn R->cbind [& data]
  (gen-R-struct :R->cbind (into [] data)))

(defn R->rbind [& data]
  (gen-R-struct :R->rbind (into [] data)))

(defn R->apply [& data]
  (gen-R-struct :R->apply (into [] data)))

(defn R->= [var-name value]
  (gen-R-struct :R->= [ var-name value]))

(defn R->vector [& data]
  (gen-R-struct :R->vector (into [] data)))

(defn R->range [low-val high-val]
  (gen-R-struct :R->range  [low-val high-val]))

(defn R->slurp [path]
  (gen-R-struct :R->slurp [path]))

(defn R->dataframe? [var]
  (gen-R-struct :R->dataframe? [(name var)]))

(defn R->vector? [var]
  (gen-R-struct :R->vector? [(name var)]))

(defn R->rownames [var]
  (gen-R-struct :R->rownames? [(name var)]))

