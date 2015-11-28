(ns production-simulation.core
  (:require [com.rpl.specter :refer :all]))

(defmacro defn-todo [s args & body]
  `(defn ~s ~args
     (println "TODO:" ~(name s) "=>" ~@body)
     ~@body))



(def buildings-path [:buildings])
(defn building-path [id] [buildings-path id])

(def locations-path [:locations])
(defn location-path [id] [locations-path id])



(defn-todo building-space-available? [location] true)

(defn building-possible? [world location building-tpl]
  ;; (enough-resources? requirements)
  (building-space-available? location))

(defmacro check [fn & args]
  `(let [result# (~fn ~@args)]
     (println "CHECK:" ~(name fn) result#)
     result#))

(def ^:dynamic *id* (atom 1))

(defn next-id [] (swap! *id* inc))

(defn conj-new [objects tpl]
  (println objects tpl)
  (conj objects (assoc tpl :id (next-id))))

(defn build [world location building-tpl]
  (check building-possible? world location building-tpl)
  (transform buildings-path
             #(conj-new % building-tpl)
             world))
             


(def *world* (atom {:buildings []}))

(swap! *world* build 123 {:type :farm})
