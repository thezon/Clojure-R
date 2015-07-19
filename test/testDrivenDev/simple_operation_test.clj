(ns testDrivenDev.simple-operation-test
  (:require [codeGeneration.RC-code-generation :refer [R->generate]]
            [dsl.primary-operations :refer :all]
            [clojure.test :refer :all]
            [dsl.composit-operations :refer :all]
            :reload))


  (testing "Mean structure taking simple numbers failed"
           (is 
             (=
               (R->generate 
                 (R->def :dog 4)
                 (R->def :m1 (R->mean 
                               (R->= :x (R->vector (R->number 1) (R->number 1) (R->number 1) (R->keyword :dog) ))
                               (R->= :y (R->vector (R->number 1) (R->number 1) (R->number 1) (R->keyword :dog) ))))
                 (R->def :m2 (R->mean 
                               (R->= :x (R->vector (R->number 1) (R->number 1) (R->number 1) (R->keyword :dog) ))
                               (R->= :y (R->vector (R->number 1) (R->number 1) (R->number 1) (R->keyword :dog) ))))
                 (R->def :m3 (R->mean 
                               (R->= :x (R->vector (R->number 1) (R->number 1) (R->number 1) (R->keyword :dog) ))
                               (R->= :y (R->vector (R->number 1) (R->number 1) (R->number 1) (R->keyword :dog) ))))
                 (R->stripchart (R->vector (R->keyword :m1) (R->keyword :m2) (R->keyword :m3))))
               
               "dog<-4;m1<-mean(x=c(1,1,1,dog),y=c(1,1,1,dog));m2<-mean(x=c(1,1,1,dog),y=c(1,1,1,dog));m3<-mean(x=c(1,1,1,dog),y=c(1,1,1,dog));stripchart(c(m1,m2,m3))"))
           (is 
             (= 
               (R->generate (mean 1 2 3))
               "mean(c(1,2,3))"))
           (is 
             (= 
               (R->generate (mean (R->vector 1 2 3)))
               "mean(c(1,2,3))")))
  