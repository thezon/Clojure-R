(ns rc.core-test
  (:require [clojure.test :refer :all]
            [rc.core :refer :all]
            :reload))



;Test driven delopement 

(deftest mean-basic-test
  (testing "Mean taking simple numbers failed"
    (is (= (R->mean 1 2 3 4) "mean(c[1,2,3,4])"))))

(deftest vector-assign-test
  (testing "Mean taking simple numbers failed"
    (is (= (R-generate (R->def :car (R->vector 1 2 3 4)))
           "car<-c[1,2,3,4]"))))

(deftest vector-mean-assign-test
  (testing "Mean taking simple numbers failed"
    (is (= (R-generate (R->def :how-much (R->mean (R->vector 1 2 3)))) "how-much<-mean(c[1,2,3])"))))


;(defn run-test-sweet []
 ; (do mean-basic-test
  ;  vector-assign-test
   ;; vector-mean-assign-test))