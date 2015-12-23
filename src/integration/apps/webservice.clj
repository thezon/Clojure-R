(ns ^{:author "Birchell"
      :doc "Service converts clojure to R"}
integration.apps.webservice
  (:require [clojure.tools.logging :as log]
            [ring.adapter.jetty :as ser]
            [rc.core :as core]
            [ring.util.codec :as code]))

(def default-service-config-map {:server "localhost"
                              :port 3131
                              :param-name "cljin"})

(def service-config-map
  (try
    (read-string (slurp "config/service-config.properties"))
  (catch Exception ex
    (do (log/error "Cannot load service config from file. Loading default configuration.")
      default-service-config-map))))
    
(defn get-request-clojure [request]
  (clojure.string/replace 
   (:query-string request) 
    (str (:param-name service-config-map) "=") ""))
        
(defn handler [request]
  (do (log/spy :info request)
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body   (rc.core/clojure-R-transform
                   (code/percent-decode 
                     (get-request-clojure request)))}))

(ser/run-jetty handler {:port (:port service-config-map)})

