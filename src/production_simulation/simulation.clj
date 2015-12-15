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
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def world (atom {:objects {} :locations {}}))

(swap! world begin-construction (loc 124) {:types #{:farm}})sav
(swap! world begin-construction (loc 124) {:types #{:city}})
(swap! world begin-construction (loc 126) {:types #{:city}})
(swap! world finish-unit (loc 124) {:capabilities {:work 10}})
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
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:objects</span>","value":":objects"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_33</span>","value":":id_33"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction-site</span>","value":":construction-site"},{"type":"html","content":"<span class='clj-keyword'>:farm</span>","value":":farm"}],"value":"#{:construction-site :farm}"}],"value":"[:types #{:construction-site :farm}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_33</span>","value":":id_33"}],"value":"[:id :id_33]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction</span>","value":":construction"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-long'>100</span>","value":"100"}],"value":"[:work 100]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:people</span>","value":":people"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"[:people 10]"}],"value":"{:work 100, :people 10}"}],"value":"[:construction {:work 100, :people 10}]"}],"value":"{:types #{:construction-site :farm}, :id :id_33, :construction {:work 100, :people 10}}"}],"value":"[:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work 100, :people 10}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_34</span>","value":":id_34"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:city</span>","value":":city"},{"type":"html","content":"<span class='clj-keyword'>:construction-site</span>","value":":construction-site"}],"value":"#{:city :construction-site}"}],"value":"[:types #{:city :construction-site}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_34</span>","value":":id_34"}],"value":"[:id :id_34]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction</span>","value":":construction"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:work 1000]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:people</span>","value":":people"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:people 1000]"}],"value":"{:work 1000, :people 1000}"}],"value":"[:construction {:work 1000, :people 1000}]"}],"value":"{:types #{:city :construction-site}, :id :id_34, :construction {:work 1000, :people 1000}}"}],"value":"[:id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 1000, :people 1000}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_35</span>","value":":id_35"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:city</span>","value":":city"},{"type":"html","content":"<span class='clj-keyword'>:construction-site</span>","value":":construction-site"}],"value":"#{:city :construction-site}"}],"value":"[:types #{:city :construction-site}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_35</span>","value":":id_35"}],"value":"[:id :id_35]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction</span>","value":":construction"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:work 1000]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:people</span>","value":":people"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:people 1000]"}],"value":"{:work 1000, :people 1000}"}],"value":"[:construction {:work 1000, :people 1000}]"}],"value":"{:types #{:city :construction-site}, :id :id_35, :construction {:work 1000, :people 1000}}"}],"value":"[:id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000, :people 1000}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_36</span>","value":":id_36"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:capabilities</span>","value":":capabilities"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"[:work 10]"}],"value":"{:work 10}"}],"value":"[:capabilities {:work 10}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_36</span>","value":":id_36"}],"value":"[:id :id_36]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:unit</span>","value":":unit"}],"value":"(:unit)"}],"value":"[:types (:unit)]"}],"value":"{:capabilities {:work 10}, :id :id_36, :types (:unit)}"}],"value":"[:id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}]"}],"value":"{:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work 100, :people 10}}, :id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 1000, :people 1000}}, :id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000, :people 1000}}, :id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}}"}],"value":"[:objects {:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work 100, :people 10}}, :id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 1000, :people 1000}}, :id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000, :people 1000}}, :id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:locations</span>","value":":locations"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:xy_124</span>","value":":xy_124"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_33</span>","value":":id_33"},{"type":"html","content":"<span class='clj-keyword'>:id_34</span>","value":":id_34"},{"type":"html","content":"<span class='clj-keyword'>:id_36</span>","value":":id_36"}],"value":"[:id_33 :id_34 :id_36]"}],"value":"[:xy_124 [:id_33 :id_34 :id_36]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:xy_126</span>","value":":xy_126"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_35</span>","value":":id_35"}],"value":"[:id_35]"}],"value":"[:xy_126 [:id_35]]"}],"value":"{:xy_124 [:id_33 :id_34 :id_36], :xy_126 [:id_35]}"}],"value":"[:locations {:xy_124 [:id_33 :id_34 :id_36], :xy_126 [:id_35]}]"}],"value":"{:objects {:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work 100, :people 10}}, :id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 1000, :people 1000}}, :id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000, :people 1000}}, :id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}}, :locations {:xy_124 [:id_33 :id_34 :id_36], :xy_126 [:id_35]}}"}
;; <=

;; @@
(nth (iterate #(work-phase % 1.0) @world) 100)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:objects</span>","value":":objects"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_33</span>","value":":id_33"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction-site</span>","value":":construction-site"},{"type":"html","content":"<span class='clj-keyword'>:farm</span>","value":":farm"}],"value":"#{:construction-site :farm}"}],"value":"[:types #{:construction-site :farm}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_33</span>","value":":id_33"}],"value":"[:id :id_33]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction</span>","value":":construction"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-double'>-400.0</span>","value":"-400.0"}],"value":"[:work -400.0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:people</span>","value":":people"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"[:people 10]"}],"value":"{:work -400.0, :people 10}"}],"value":"[:construction {:work -400.0, :people 10}]"}],"value":"{:types #{:construction-site :farm}, :id :id_33, :construction {:work -400.0, :people 10}}"}],"value":"[:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work -400.0, :people 10}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_34</span>","value":":id_34"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:city</span>","value":":city"},{"type":"html","content":"<span class='clj-keyword'>:construction-site</span>","value":":construction-site"}],"value":"#{:city :construction-site}"}],"value":"[:types #{:city :construction-site}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_34</span>","value":":id_34"}],"value":"[:id :id_34]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction</span>","value":":construction"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-double'>500.0</span>","value":"500.0"}],"value":"[:work 500.0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:people</span>","value":":people"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:people 1000]"}],"value":"{:work 500.0, :people 1000}"}],"value":"[:construction {:work 500.0, :people 1000}]"}],"value":"{:types #{:city :construction-site}, :id :id_34, :construction {:work 500.0, :people 1000}}"}],"value":"[:id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 500.0, :people 1000}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_35</span>","value":":id_35"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:city</span>","value":":city"},{"type":"html","content":"<span class='clj-keyword'>:construction-site</span>","value":":construction-site"}],"value":"#{:city :construction-site}"}],"value":"[:types #{:city :construction-site}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_35</span>","value":":id_35"}],"value":"[:id :id_35]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:construction</span>","value":":construction"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-double'>1000.0</span>","value":"1000.0"}],"value":"[:work 1000.0]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:people</span>","value":":people"},{"type":"html","content":"<span class='clj-long'>1000</span>","value":"1000"}],"value":"[:people 1000]"}],"value":"{:work 1000.0, :people 1000}"}],"value":"[:construction {:work 1000.0, :people 1000}]"}],"value":"{:types #{:city :construction-site}, :id :id_35, :construction {:work 1000.0, :people 1000}}"}],"value":"[:id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000.0, :people 1000}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_36</span>","value":":id_36"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:capabilities</span>","value":":capabilities"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:work</span>","value":":work"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"[:work 10]"}],"value":"{:work 10}"}],"value":"[:capabilities {:work 10}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id</span>","value":":id"},{"type":"html","content":"<span class='clj-keyword'>:id_36</span>","value":":id_36"}],"value":"[:id :id_36]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:types</span>","value":":types"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:unit</span>","value":":unit"}],"value":"(:unit)"}],"value":"[:types (:unit)]"}],"value":"{:capabilities {:work 10}, :id :id_36, :types (:unit)}"}],"value":"[:id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}]"}],"value":"{:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work -400.0, :people 10}}, :id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 500.0, :people 1000}}, :id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000.0, :people 1000}}, :id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}}"}],"value":"[:objects {:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work -400.0, :people 10}}, :id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 500.0, :people 1000}}, :id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000.0, :people 1000}}, :id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}}]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:locations</span>","value":":locations"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:xy_124</span>","value":":xy_124"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_33</span>","value":":id_33"},{"type":"html","content":"<span class='clj-keyword'>:id_34</span>","value":":id_34"},{"type":"html","content":"<span class='clj-keyword'>:id_36</span>","value":":id_36"}],"value":"[:id_33 :id_34 :id_36]"}],"value":"[:xy_124 [:id_33 :id_34 :id_36]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:xy_126</span>","value":":xy_126"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:id_35</span>","value":":id_35"}],"value":"[:id_35]"}],"value":"[:xy_126 [:id_35]]"}],"value":"{:xy_124 [:id_33 :id_34 :id_36], :xy_126 [:id_35]}"}],"value":"[:locations {:xy_124 [:id_33 :id_34 :id_36], :xy_126 [:id_35]}]"}],"value":"{:objects {:id_33 {:types #{:construction-site :farm}, :id :id_33, :construction {:work -400.0, :people 10}}, :id_34 {:types #{:city :construction-site}, :id :id_34, :construction {:work 500.0, :people 1000}}, :id_35 {:types #{:city :construction-site}, :id :id_35, :construction {:work 1000.0, :people 1000}}, :id_36 {:capabilities {:work 10}, :id :id_36, :types (:unit)}}, :locations {:xy_124 [:id_33 :id_34 :id_36], :xy_126 [:id_35]}}"}
;; <=

;; @@

;; @@
