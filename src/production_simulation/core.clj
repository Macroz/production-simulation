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

(defn construction-site? [object]
  (some #{:construction-site} (:types object)))

(defn worker? [object]
  (contains? (:capabilities object) :work))

(defn work-at-site [world [site work]]
  (transform [objects-path (:id site) :construction :work]
             #(- % work)
             world))

(defn work-phase [world]
  (let [construction-sites (select [objects-path ALL (view val) construction-site?] world)
        sites-by-id (group-by :id construction-sites)
        workers (select [objects-path ALL (view val) worker?] world)
        workers-by-id (group-by :id workers)
        locations (select [locations-path ALL (view second)] world)
        site-work (doall (mapcat (fn [location]
                                   (let [sites (mapcat sites-by-id location)
                                         workers (mapcat workers-by-id location)]
                                     (when (and sites workers)
                                       (let [total-work (reduce + (select [ALL :capabilities :work] workers))
                                             work-per-site (/ total-work (count sites))]
                                         (for [site sites]
                                           [site work-per-site])))))
                                 locations))]
    (reduce work-at-site world site-work)))

(defn finish-unit [world location unit-tpl]
  (let [unit (-> (instantiate unit-tpl)
                 (update-in [:types] conj :unit))
        id (:id unit)]
    (->> world
         (transform [objects-path id] (fn [_] unit))
         (transform [locations-path location] #(vconj % id)))))

(def ^:dynamic *world* (atom {:objects {} :locations {}}))

(swap! *world* begin-construction (loc 124) {:types #{:farm}})
(swap! *world* begin-construction (loc 124) {:types #{:city}})
(swap! *world* begin-construction (loc 126) {:types #{:city}})
(swap! *world* finish-unit (loc 124) {:capabilities {:work 10}})
(swap! *world* work-phase)

(defn ->object [id]
  (get-in @*world* [:objects id]))

(defn spy [e]
  (println "spied" (pr-str e))
  e)

;;(println (select [locations-path :xy_124 ALL ->object spy] @*world*))
(def t (select [locations-path :xy_124 ALL (view ->object)] @*world*))

(def k (select [locations-path :xy_124 ALL (view ->object) construction-site?] @*world*))
