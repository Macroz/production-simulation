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



(def objects-path [:objects])
(defn object-path [id] [objects-path id])

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

(defn requirements-for [building-tpl]
  ({:farm {:work 100 :people 10}
    :city {:work 1000 :people 1000}} (first (:types building-tpl))))

(defn setup-construction-site [building-tpl]
  (->> building-tpl
       (transform [:construction] (fn [_] (requirements-for building-tpl)))
       (transform [:types] (fn [s] (conj s :construction-site)))))

(defn begin-construction [world location building-tpl]
  (check building-possible? world location building-tpl)
  (let [building (-> (instantiate building-tpl)
                     (setup-construction-site))
        id (:id building)]
    (->> world
         (transform [objects-path id] (fn [_] building))
         (transform [locations-path location] #(vconj % id)))))

(def ^:dynamic *world* (atom {:objects {} :locations {}}))

(swap! *world* begin-construction (loc 124) {:types #{:farm}})
(swap! *world* begin-construction (loc 124) {:types #{:city}})
(swap! *world* begin-construction (loc 126) {:types #{:city}})
