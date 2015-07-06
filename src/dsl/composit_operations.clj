(ns dsl.composit-operations
   (:require  [support.RC-support :as sup]
              [codeGeneration.RC-code-generation :as gen]))

(defn R->mean [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->mean (sup/stnd-input-support data)))

(defn R->summary [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->summary (sup/stnd-input-support data)))

(defn R->dataframe [& data]
  "attribute map"
  (gen/gen-R-struct :R->dataframe (sup/stnd-input-support data [:map :r-srt])))

(defn R->matrix [& data]
  "attribute map"
  (gen/gen-R-struct :R->matrix (sup/stnd-input-support data [:map :r-srt])))