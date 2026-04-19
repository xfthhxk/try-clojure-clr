(ns dev
  (:require
   [clojure.tools.nrepl :as nrepl]))


(defonce ^:dynamic *nrepl-server* nil)


;; (when-not *nrepl-server*
;;   (println "Starting nrepl server...")
;;   (let [srv (nrepl/start-server!)]
;;     (alter-var-root #'*nrepl-server* (constantly srv))))

(defn restart!
  []
  (println "do something here")
  :restarted)
