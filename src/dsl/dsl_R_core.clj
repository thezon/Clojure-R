(ns dsl.dsl-R-core
  (:require [transformation.R-struct-gen :as R]))

(defn R->range [low-val high-val]
  (R/R->range (R/R->number low-val) (R/R->number high-val)))

(defn R->def [var-name val]
  (R/R->def (R/R->raw var-name)
            (cond
              (string? val)
              (R/R->string val)
              (:R-struct val)
              val
              :default
              (R/R->raw val))))

(defn R->print [val]
  (if (string? val)
    (R/R->print (R/R->string val))
    (R/R->print R/R->raw val)))