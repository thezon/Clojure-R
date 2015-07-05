(ns testDrivenDev.integration-test)

(deftest mean-complex-test
  (testing "Mean taking simple numbers failed"
    (is (=  (R->def :mymean (R->mean {:x (R->vector 1 2 3 4 5)})) 
            {:R-struct true, :oper :R->def, :parms [:mymean {:R-struct true, :oper :R->mean, :parms [{:R-struct true, :oper :R->=, :parms [:x {:R-struct true, :oper :R->vector, :parms [[1 2 3 4 5]]}]}]}]})))
    (testing "Mean taking simple numbers failed"
    (is
      (=  
        (R->generate (R->def :mymean (R->mean {:x (R->vector 1 2 3 4 5)})))
        "mymean<-mean(x=c(1,2,3,4,5))"))))
