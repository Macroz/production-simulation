(ns production-simulation.core
  (:require [com.rpl.specter :refer :all]))

(defn vconj [coll x]
  (if coll
    (conj coll x)
    (vector x)))



(defmacro defn-todo [s args & body]
  `(defn ~s ~args
     (println "TODO:" ~(name s) "=>" ~@body)
     ~@body))

(defmacro check [fn & args]
  `(let [result# (~fn ~@args)]
     (println "CHECK:" ~(name fn) result#)
     result#))



(def buildings-path [:buildings])
(defn building-path [id] [buildings-path id])

(def locations-path [:locations])
(defn location-path [id] [locations-path id])



(def ^:dynamic *id* (atom 0))

(defn next-id []
  (let [x (swap! *id* inc)]
    (keyword (str "id_" x))))



(defn-todo building-space-available? [location] true)

(defn building-possible? [world location building-tpl]
  ;; (enough-resources? requirements)
  (building-space-available? location))

(defn instantiate [tpl]
  (assoc tpl :id (next-id)))

(defn loc [x]
  (keyword (str "xy_" x)))


(defn build [world location building-tpl]
  (check building-possible? world location building-tpl)
  (let [building (instantiate building-tpl)
        id (:id building)]
  (->> world
       (transform [buildings-path id] (fn [_] building))
       (transform [locations-path location] #(vconj % id)))))
             


(def ^:dynamic *world* (atom {:buildings {} :locations {}}))

(swap! *world* build (loc 124) {:type :farm})
(swap! *world* build (loc 124) {:type :city})
