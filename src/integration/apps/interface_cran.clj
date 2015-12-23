(ns ^{:author "Birchell"
      :doc "Entry point for cran configuration and application initialization"}
integration.apps.interface-cran
  (:require [clojure.tools.logging :as log]))

(def default-cran-config-map {:input-location "input-location"
                              :input-file-name "filename"
                              :output-location "output-location"
                              :output-file-name "filename" })

(def cran-config-map
  (try
    (read-string (slurp "config/cran-config.txt"))
  (catch Exception ex
    (do (log/error "Cannot load cran config from file. Loading default configuration.")
      default-cran-config-map))))
    
  
(comment "This will check input file for changes and transform if changes occur and put in ouput file")
(defn run-cran-instance []
  (println "running cran intance"))

