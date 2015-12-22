(ns testDrivenDev.dsl-dotchart-test
   (:require [clojure.test :refer :all]
            [dsl.dsl-dotchart :as dot]
            [transformation.code-generation :as gen]
            [dsl.dsl-vector :as vec]))


(deftest perform-test
  (testing "Failed testing mean-configured"
           (is
             (= "dotchart(x=c(1,4,3));" 
                (gen/R->generate (dot/dotchart-attributes {:x (vec/vector-simple 1 4 3)}))))))


