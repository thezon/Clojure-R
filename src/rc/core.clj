(ns rc.core
  (:require 
    [transformation.code-generation :refer [R->generate] :rename {R->generate generate}]
    [dsl.dsl-mean]
    [dsl.dsl-matrix]
    [dsl.dsl-vector]
    [dsl.dsl-boxplot]
    [dsl.dsl-dotchart]))


;use this for convient repl sandbox


