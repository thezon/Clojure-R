(ns testDrivenDev.simple-operation-test
  (:require [codeGeneration.RC-code-generation :refer [R->generate]]
            [dsl.primary-operations :refer :all]
            [dsl.composit-operations :refer :all]
            [clojure.test :refer :all]
            :reload))

(deftest mean-basic-test
  (testing "Mean structure taking simple numbers failed"
           (is (=  (R->mean 1 1 3 3) 
                   {:R-struct true, :oper :R->mean, :parms [{:R-struct true, :oper :R->vector, :parms [[1 1 3 3]]}]})))
  (testing "Mean output taking simple numbers failed"
           (is (=  (R->generate (R->mean 1 1 3 3)) "mean(c(1,1,3,3))"))))

(deftest vector-basic-test
  (testing "vector structrure taking simple numbers failed"
           (is (=  (R->vector 1 2 3 4 5) 
                   {:R-struct true, :oper :R->vector, :parms [[1 2 3 4 5]]})))
  (testing "vector output taking simple numbers failed"
           (is (=  (R->generate (R->vector 1 2 3 4 5)) "c(1,2,3,4,5)"))))

(deftest summary-basic-test
  (testing "summary structure taking simple numbers failed"
           (is (= (R->summary 1 2 3 4) 
                  {:R-struct true, :oper :R->summary, :parms [{:R-struct true, :oper :R->vector, :parms [[1 2 3 4]]}]})))
  (testing "summary output taking simple numbers failed"
           (is (= (R->generate (R->summary 1 2 3 4)) "summary(c(1,2,3,4))"))))

(defn run-all []
  (do 
    (mean-basic-test)
    (vector-basic-test)
    (summary-basic-test)))
