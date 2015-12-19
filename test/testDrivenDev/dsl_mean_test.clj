(ns testDrivenDev.dsl-mean-test
  (:require [clojure.test :refer :all]
            [codeGeneration.RC-code-generation :as gen]
            [dsl.dsl-mean :as mean]
            [codeGeneration.base-operators :as R]
            [dsl.dsl-vector :as vec]
            :reload))

(testing "Failed testing mean-configured"
         (is
           (= "mean(x=c(1,4,3))" 
              (gen/R->generate (mean/mean-configured {:x (vec/vector-simple 1 4 3)})))))


(testing "Failed testing matrix-configured"
         (is
           (= "mean(c(1,4,3))" 
              (gen/R->generate (mean/mean-simple (vec/vector-simple 1 4 3)))))
         (is
           (= "mean(c(1,4,3))" 
              (gen/R->generate (mean/mean-simple [1 4 3]))))
         (is
           (= "mean(c(1,4,3))" 
              (gen/R->generate (mean/mean-simple #{1 4 3}))))
         (is
           (= "mean(c(1,4,3))" 
              (gen/R->generate (mean/mean-simple 1 4 3)))))
