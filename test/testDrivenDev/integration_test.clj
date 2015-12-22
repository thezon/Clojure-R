(ns testDrivenDev.integration-test
  (:require [transformation.code-generation :as gen]
            [transformation.R-thin-client :refer :all] 
            [dsl.dsl-boxplot :as box]
            [transformation.code-generation :as gen]
            [dsl.dsl-dataframe :as df]
            [clojure.test :refer :all]
            :reload))

(comment "need to refactor testing scripts"
(deftest mean-complex-test
  (testing "mean structure taking map and vector failed"
    (is
      (= 
        (R->def :mymean (R->mean {:x (R->vector 1 2 3 4 5)})) 
        {:R-struct true, :oper :R->def, :parms [:mymean {:R-struct true, :oper :R->mean, :parms [{:R-struct true, :oper :R->=, :parms [:x {:R-struct true, :oper :R->vector, :parms [[1 2 3 4 5]]}]}]}]})))
  (testing "Mean output taking map and vector numbers failed"
           (is
             (=  
               (R->generate (R->def :mymean (R->mean {:x (R->vector 1 2 3 4 5)})))
               "mymean<-mean(x=c(1,2,3,4,5))"))))

(deftest summary-complex-test
  (testing "mean structure taking map and vector failed"
           (is 
             (=  
               (R->def :mymean (R->summary {:x (R->vector 1 2 3 4 5)})) 
               {:R-struct true, :oper :R->def, :parms [:mymean {:R-struct true, :oper :R->summary, :parms [{:R-struct true, :oper :R->=, :parms [:x {:R-struct true, :oper :R->vector, :parms [[1 2 3 4 5]]}]}]}]})))
  (testing "Mean output taking map and vector numbers failed"
           (is
             (=  
               (R->generate (R->def :mymean (R->summary {:x (R->vector 1 2 3 4 5)})))
               "mymean<-summary(x=c(1,2,3,4,5))"))))

(defn run-all []
  (do (summary-complex-test)
    (mean-complex-test)))
)