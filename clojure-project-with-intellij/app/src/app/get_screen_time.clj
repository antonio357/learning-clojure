(ns app.get-screen-time
  (:require [app.load_data :refer [get-data]])
  (:require [app.time :refer [get-time-interval]]))

(def ^:private db (get-data))

(defn print-screen-time [screen-time]
  (map #(prn % (% screen-time)) (keys screen-time)))

; with atoms
; now it works the problem was the internal maps returned empty collections with just nil inside so clojure interpred as lazy sqe and it woul only execute code that returns lazy seq if it will use the values

(defn- get-characters-from-scene [scene]
  (->> (:characters scene)
       (map :name)
       (set)
       (vec)))

(defn- get-episodes [db]
  (->> (:episodes db)
       (:data)
       (:episodes)))

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

(def ^:private screen-time (atom {}))
(get-screen-time db screen-time)
(print-screen-time @screen-time)


;better way to do, no atoms
(defn- get-json-data [db json-name]
  (let [json-name (keyword json-name)] (-> (json-name db)
                                           (:data)
                                           (json-name))))

(defn- get-characters [db]
  (->> (get-json-data db "characters")
       (map #(:characterName %))
       (set)
       (vec)))

; return :character-name screen-time
(defn- get-character-screen-time [character, episodes]
  (map [] episodes))
