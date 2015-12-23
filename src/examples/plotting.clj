(ns examples.plotting
    (:require 
    [transformation.code-generation :refer [R->generate] :rename {R->generate generate}]
    [dsl.dsl-mean :refer :all]
    [dsl.dsl-matrix :refer :all]
    [dsl.dsl-vector :refer :all]
    [dsl.dsl-boxplot :refer :all]
    [dsl.dsl-dotchart :refer :all]
    [dsl.dsl-dataframe :refer :all]
    [transformation.R-struct-gen :refer :all]
    [transformation.R-thin-client :as tc]))

(defn boxplot-exp-1 []
  "create boxplot with 10 random vectors values ranging from 0 to 99"
  (generate (boxplot-attributes 
              {:x (apply dataframe-vec 
                         (repeatedly 5
                                     (fn [] (into [] (repeatedly 10 #(rand-int 100))))))})))

(defn dataframe-exp-2 []
  "create a dataframe"
  (generate
    (dataframe-variables 
      (R->=
        (R->raw "test1")
        (vector-simple 1 2 3))
      (R->=
        (R->raw "test2")
        (vector-simple 1 2 3)))))