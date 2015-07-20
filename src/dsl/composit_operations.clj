(ns dsl.composit-operations
  (:require  [support.RC-support :as sup]
             [codeGeneration.RC-code-generation :as gen]
             [dsl.primary-operations :as R]))

(defn mean [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (apply R/R->mean (sup/stnd-input-support data)))

(defn summary [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (apply R/R->summary (sup/stnd-input-support data)))

(defn dataframe [& data]
  "attribute map"
  (apply R/R->dataframe (sup/stnd-input-support data [:map :r-srt])))

(defn matrix [& data]
  "attribute map"
  (apply R/R->matrix (sup/stnd-input-support data [:map :r-srt])))
