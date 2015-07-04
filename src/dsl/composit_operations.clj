(ns dsl.composit-operations
   (:require  [support.RC-support :as sup]
              [codeGeneration.RC-code-generation :as gen]))

(defn R->mean [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->mean (sup/stnd-input-support data)))

(defn R->summary [& data]
  "Takes vector, R-vector, numbers or attribute map"
  (gen/gen-R-struct :R->summary (sup/stnd-input-support data)))