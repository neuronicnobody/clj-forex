(ns forex.backend.common.core
  (:use utils.general emacs))
 
;;common global vars
(defonce *main-streams* (atom {}))
(defonce *main-stream-lock*  (java.util.concurrent.locks.ReentrantReadWriteLock.))

(defonce *streams* (atom {}))
(defonce *indicators* (atom {}))
(defonce *indicator-lock*  (java.util.concurrent.locks.ReentrantReadWriteLock.))
(defonce *stream-lock* (java.util.concurrent.locks.ReentrantReadWriteLock.))

(def *backend* nil)
(defprotocol PBackend
  "Backend Interface"
  (get-price-stream [this symbol timeframe])
  (alive? [this])
  (start [this params])
  (stop [this params]))
;; 