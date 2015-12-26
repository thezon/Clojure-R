(ns testDrivenDev.dsl-dotchart-test
   (:require [clojure.test :refer :all]
            [dsl.dsl-dotchart :as dot]
            [transformation.code-generation :as gen]
            [dsl.dsl-vector :as vec]))


(deftest perform-test
  (testing "Failed testing R->mean-configured"
           (is
             (= "dotchart(x=c(1,4,3));" 
                (gen/R->generate (dot/R->dotchart-attributes {:x (vec/R->vector-simple 1 4 3)}))))))


