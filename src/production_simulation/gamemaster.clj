(ns production-simulation.gamemaster
  (:require [clojure.string :as string]
            [clojure.core.strint :refer [<<]]))

(defn desc [x]
  (str (string/join " " (:adjectives x []))
       (cond (and (< (:age x) 15) (= (:gender x) :male)) "boy")))

(defn indef [x]
  (let [d (desc x)]
    (str "a " d)))

(defn name [x]
  (:name x))

(defn full [x]
  (str (desc x)  " " (name x)))

(defmacro with-ctx [ctx & body]
  `(let [~'hero (:hero ~ctx)
         ~'villain (:villain ~ctx)]
     ~@body))

(defmacro defstory [id & body]
  `(defn ~id [ctx#]
     (with-ctx ctx#
       ~@body)))

(defstory Beginning
  {:text [(<< "A long time ago in a galaxy far far away. There was ~(indef hero) named ~(name hero).")]})

(defstory Middle
  {:text [(<< "~(name hero) defeated ~(full villain).")]})

(defstory End
  {:text [(<< "And ~(name hero) lived happily ever after.")]})

(defn Story [ctx]
  {:parts [Beginning Middle End]})

(defn tell [ctx story]
  (cond
    (:text story) (string/join " " (:text story))
    (:parts story) (string/join "\n" (doall (map (partial tell ctx) (:parts story))))
    (fn? story) (tell ctx (story ctx))))

(println (tell {:hero {:name "Luke" :gender :male :age 10}
                :villain {:name "Vader" :gender :male :age 40 :adjectives ["evil"]}}
                Story))



;; event

;; inputs -> xxx -> outputs

;; Major players
;; - Noble Houses
;; - Minor Houses
;; - League
;; - Church
;; - Sathraists
;; - Vau
;; - Symbiots
;; - Minor Aliens
;; - Demons

;; Game = Beginning Middle End

;; Beginning = Intro PlayerSelection BackgroundStory Tutorial Challenge

;; Middle = Challenge+

;; Challenge = Setup GamePlay Resolution | Setup GamePlay Cliffhanger Resolution

;; End = FinalBoss AfterStory Credits
