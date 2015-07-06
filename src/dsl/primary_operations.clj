(ns dsl.primary-operations
  (:require [codeGeneration.RC-code-generation :as gen]))

(defn R->def [var-name value]
  (gen/gen-R-struct :R->def [var-name value]))

(defn R->vector [& values]
  (gen/gen-R-struct :R->vector [(into [] values)]))

(defn R->= [var-name value]
  (gen/gen-R-struct :R->= [var-name value]))

(defn R->vector [& values]
  (gen/gen-R-struct :R->vector [(into [] values)]))

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
