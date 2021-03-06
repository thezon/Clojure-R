(ns ^{:author "Birchell"
      :doc "Entry point for application that loads all configurations and initializes applications.
            Default configuration is dev enviroment."}
integration.apps.loader
  (:require [integration.apps.webservice :as serv]
            [integration.apps.integration-java :as java]
            [clojure.tools.logging :as log])
  (:gen-class))

(defn get-config []
  (try
    (read-string (slurp "config/clojure-R-config.properties"))
    (catch Exception ex 
      (do
        (log/error "cannot load clojure-R-config.")
        {:instance :dev}))))

(defn -main
  []
  (try 
    (let [conf-map (get-config)]
      (cond
        (= :serv (:instance conf-map))
        (cran/run-cran-instance)
        (= :java (:instance conf-map))
        (java/run-java-instance)
        :default
        (log/info "loading default configuration: developement")))))
  

