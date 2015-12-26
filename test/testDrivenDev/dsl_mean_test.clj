(ns testDrivenDev.dsl-mean-test
  (:require [clojure.test :refer :all]
            [transformation.code-generation :as gen]
            [dsl.dsl-mean :as mean]
            [transformation.R-thin-client :as R]
            [dsl.dsl-vector :as vec]
            :reload))

(deftest perform-test 
    (testing "Failed testing R->mean-configured"
             (is
               (= "mean(x=c(1,4,3));" 
                  (gen/R->generate (mean/R->mean-configured {:x (vec/R->vector-simple 1 4 3)})))))
    
    
    (testing "Failed testing R->matrix-configured"
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/R->mean-simple (vec/R->vector-simple 1 4 3)))))
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/R->mean-simple [1 4 3]))))
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/R->mean-simple #{1 4 3}))))
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/R->mean-simple 1 4 3))))))
    