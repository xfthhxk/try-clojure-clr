(ns dev
  (:require
   [clojure.tools.nrepl :as nrepl]))

(defonce ^:dynamic *nrepl-server* nil)

(defn restart!
  []
  (println "do something here")
  :restarted)

(when-not *nrepl-server*
  (let [srv (nrepl/start-server!)]
    (alter-var-root #'*nrepl-server* (constantly srv))))
