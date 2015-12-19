(ns testDrivenDev.dsl-matrix-test
  (:require [clojure.test :refer :all]
            [codeGeneration.RC-code-generation :as gen]
            [dsl.dsl-matrix :as mat]
            [dsl.dsl-vector :as vec]
            [codeGeneration.base-operators :as R]
            :reload))

(testing "Failed testing matrix-simple"
         (is
           (= "matrix(nrow=20,ncol=20,data=c(1,4,3))" 
              (gen/R->generate (mat/matrix-simple 20 20 [1 4 3]))))
         (is
           (= "matrix(nrow=20,ncol=20,data=c(1,4,3))" 
              (gen/R->generate (mat/matrix-simple 20 20 #{1 4 3}))))
         (is
           (= "matrix(nrow=20,ncol=20,data=c(1,4,3))" 
              (gen/R->generate (mat/matrix-simple 20 20 (vec/vector-simple 1 4 3))))))

(testing "Failed testing matrix-configured"
         (is
           (= "matrix(nrow=20,ncol=20,data=c(1,4,3))" 
              (gen/R->generate (mat/matrix-configured {:nrow 20 :ncol 20 :data (vec/vector-simple 1 4 3)})))))
