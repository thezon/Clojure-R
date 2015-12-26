(ns testDrivenDev.dsl-dataframe-test
   (:require [clojure.test :refer :all]
            [dsl.dsl-dataframe :as df]
            [transformation.code-generation :as gen]
            [dsl.dsl-vector :as vec]))

(deftest perform-test
  (testing "Failed testing boxplot-attrubutes"
           (is
             (= "data.frame(c(1,1,2),c(3,4,5));"
                (gen/R->generate (df/R->dataframe-vec [1 1 2][3 4 5]))))))

