;; gorilla-repl.fileformat = 1

;; **
;;; # Production Simulation
;;; 
;;; Explore production simulation modeling with [Specter](https://github.com/nathanmarz/specter) in a game-like environment.
;; **

;; @@
(ns simulation
  (:require [gorilla-plot.core :as plot])
  (:use [production-simulation.core]))
;; @@
;; ->
;;; TODO: building-space-available? =&gt; true
;;; CHECK: building-possible? true
;;; TODO: building-space-available? =&gt; true
;;; CHECK: building-possible? true
;;; TODO: building-space-available? =&gt; true
;;; CHECK: building-possible? true
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def world (atom {:objects {} :locations {}}))

(swap! world begin-construction (loc 124) {:types #{:farm}})
(swap! world begin-construction (loc 124) {:types #{:city}})
(swap! world begin-construction (loc 126) {:types #{:city}})
(swap! world finish-unit (loc 124) {:capabilities {:work 10}})
(swap! world work-phase 1.0)

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/world</span>","value":"#'user/world"}
;; <=

;; @@
save
;; @@
