(ns dsl.composit-operations
  (:require  [support.RC-support :as sup]
             [transformation.code-generation :as gen]
             [transformation.R-thin-client :as R]))

; needs to be removed

(defn summary [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (apply R/R->summary (sup/stnd-input-support data)))

(defn dataframe [& data]
  "attribute map"
  (apply R/R->dataframe (sup/stnd-input-support data [:map :r-srt])))

