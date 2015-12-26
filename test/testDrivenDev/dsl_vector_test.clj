(ns testDrivenDev.dsl-vector-test
  (:require [clojure.test :refer :all]
            [transformation.code-generation :as gen]
            [dsl.dsl-vector :as vec]))

(deftest perform-test 
    (testing "Failed testing R->vector-simple"
             (is
               (= "c(1,4,3);" 
                  (gen/R->generate (vec/R->vector-simple [1 4 3]))))
             (is
               (= "c(1,4,3);" 
                  (gen/R->generate (vec/R->vector-simple  #{1 4 3}))))
             (is
               (= "c(1,4,3);" 
                  (gen/R->generate (vec/R->vector-simple 1 4 3))))))
