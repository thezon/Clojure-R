(ns testDrivenDev.dsl-mean-test
  (:require [clojure.test :refer :all]
            [transformation.code-generation :as gen]
            [dsl.dsl-mean :as mean]
            [transformation.R-thin-client :as R]
            [dsl.dsl-vector :as vec]
            :reload))

(deftest perform-test 
    (testing "Failed testing mean-configured"
             (is
               (= "mean(x=c(1,4,3));" 
                  (gen/R->generate (mean/mean-configured {:x (vec/vector-simple 1 4 3)})))))
    
    
    (testing "Failed testing matrix-configured"
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/mean-simple (vec/vector-simple 1 4 3)))))
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/mean-simple [1 4 3]))))
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/mean-simple #{1 4 3}))))
             (is
               (= "mean(c(1,4,3));" 
                  (gen/R->generate (mean/mean-simple 1 4 3))))))
    