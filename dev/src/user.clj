(ns user
  (:require
   [clojure.tools.nrepl :as nrepl]))

;; ------------------------------------------------------------------------
;; WARNING         WARNING         WARNING         WARNING         WARNING
;;
;;  This namespace is always loaded even in CI so can't put any code in here
;;  to auto start system. Put that in the dev ns
;;
;; WARNING         WARNING         WARNING         WARNING         WARNING
;; ----------------------------------------------------------------------

(defonce ^:dynamic *nrepl-server* nil)

(defn dev
  "Load and switch to the 'dev' namespace."
  []
  (require 'dev)
  (in-ns 'dev)
  :loaded)


(when-not *nrepl-server*
  (let [srv (nrepl/start-server!)]
    (alter-var-root #'*nrepl-server* (constantly srv))))
