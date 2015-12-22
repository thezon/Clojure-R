(ns testDrivenDev.test-scripts
  (:require [testDrivenDev.dsl-boxplot-test :as bp]
            [testDrivenDev.dsl-dotchart-test :as dc]
            [testDrivenDev.dsl-histogram-test :as h]
            [testDrivenDev.dsl-matrix-test :as mx]
            [testDrivenDev.dsl-mean-test :as m]
            [testDrivenDev.dsl-vector-test :as v]))

(v/perform-test)

(m/perform-test)

(mx/perform-test)

(h/perform-test)

(bp/perform-test)

(dc/perform-test)

(mx/perform-test)



