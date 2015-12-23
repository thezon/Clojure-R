(ns rc.sandbox)

(require 
  '[transformation.code-generation :refer [R->generate] :rename {R->generate generate}]
  '[dsl.dsl-mean :refer :all]
  '[dsl.dsl-matrix :refer :all]
  '[dsl.dsl-vector :refer :all]
  '[dsl.dsl-boxplot :refer :all]
  '[dsl.dsl-dotchart :refer :all]
  '[dsl.dsl-dataframe :refer :all]
  '[transformation.R-struct-gen :refer :all]
  '[transformation.R-thin-client :as tc])
