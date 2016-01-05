(ns production-simulation.hex)

(def hex-types {:forest {:type :forest}
                :plain {:type :plain}})

(def hexes (map hex-types [:forest :plain]))

(defn get-hex [hex-id]
  (nth hexes hex-id))

(def h (get-hex 1))
