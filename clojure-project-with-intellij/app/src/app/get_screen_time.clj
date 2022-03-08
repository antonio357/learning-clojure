(ns app.get-screen-time
  (:require [app.getData :refer [get-data]])
  (:require [app.time :refer [get-time-interval]]))

(defn print-screen-time [screen-time]
  (map #(prn % (% screen-time)) (keys screen-time)))

(defn get-characters-from-scene [scene]
  (->> (:characters scene)
       (map :name)
       (set)
       (vec)))

(defn get-episodes [db]
  (->> (:episodes db)
       (:data)
       (:episodes)))

; with atoms
; now it works the problem was the internal maps returned empty collections with just nil inside so clojure interpred as lazy sqe and it woul only execute code that returns lazy seq if it will use the values
(defn- get-screen-time [db atom-map]
  (->> (get-episodes db)
       (map (fn [episode] (doall (as-> (:scenes episode) scenes
                                       (map (fn [scene] (let [screen-time (atom 0) characters (atom [])]
                                                          (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                                                          (reset! screen-time (get-time-interval (:sceneStart scene) (:sceneEnd scene)))
                                                          (reset! characters (get-characters-from-scene scene))
                                                          (map (fn [character] (let [character (keyword character)]
                                                                                 (if (contains? @atom-map character)
                                                                                   (swap! atom-map #(assoc % character (+ (character %) @screen-time)))
                                                                                   (swap! atom-map #(assoc % character @screen-time))))) @characters))) scenes)))))))

(def db (get-data))
(def ^:private screen-time (atom {}))
(get-screen-time db screen-time)
(print-screen-time @screen-time)


;better way to do, no atoms
