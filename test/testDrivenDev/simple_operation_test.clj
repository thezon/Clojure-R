(ns testDrivenDev.simple-operation-test
  (:require [codeGeneration.RC-code-generation :refer [R->generate R->generate-command]]
            [dsl.primary-operations :refer :all]
            [dsl.composit-operations :refer :all]
            [clojure.test :refer :all]
            :reload))

(deftest mean-basic-test
  (testing "Mean taking simple numbers failed"
    (is (=  (R->mean 1 1 3 3) 
            {:R-struct true, :oper :R->mean, :parms [{:R-struct true, :oper :R->vector, :parms [[1 1 3 3]]}]})))
    (testing "Mean taking simple numbers failed"
    (is (=  (R->generate (R->mean 1 1 3 3)) "mean(c(1,1,3,3))"))))

(deftest vector-basic-test
  (testing "Mean taking simple numbers failed"
    (is (=  (R->vector 1 2 3 4 5) 
            {:R-struct true, :oper :R->vector, :parms [[1 2 3 4 5]]})))
    (testing "Mean taking simple numbers failed"
    (is (=  (R->generate (R->vector 1 2 3 4 5)) "c(1,2,3,4,5)"))))
