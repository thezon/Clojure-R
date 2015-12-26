(ns testDrivenDev.dsl-boxplot-test
  (:require [clojure.test :refer :all]
            [dsl.dsl-boxplot :as box]
            [transformation.code-generation :as gen]
            [dsl.dsl-vector :as vec]))

(deftest perform-test
  (testing "Failed testing boxplot-attrubutes"
           (is
             (= "boxplot(x=c(1,4,3));" 
                (gen/R->generate (box/R->boxplot-attributes {:x (vec/R->vector-simple 1 4 3)}))))))
