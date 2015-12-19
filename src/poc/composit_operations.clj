(ns dsl.composit-operations
  (:require  [support.RC-support :as sup]
             [codeGeneration.RC-code-generation :as gen]
             [codeGeneration.base-operators :as R]))

; needs to be removed

(defn summary [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (apply R/R->summary (sup/stnd-input-support data)))

(defn dataframe [& data]
  "attribute map"
  (apply R/R->dataframe (sup/stnd-input-support data [:map :r-srt])))

