(ns testDrivenDev.dsl-histogram-test
  (:require [clojure.test :refer :all]
            [dsl.dsl-histogram :as histogram]
            [transformation.code-generation :as gen]
            [dsl.dsl-vector :as vec]))

(deftest perform-test 
  (testing "Failed testing histogram-attrubutes"
           (is
             (= "hist(x=c(1,4,3));" 
                (gen/R->generate (histogram/histogram-attributes {:x (vec/vector-simple 1 4 3)}))))))
