(ns app.core
  (:require [app.getData :refer [get-data]])
  (:require [app.time :refer [get-time-interval]]))

; pegar dados da api https://raw.githubusercontent.com/jeffreylancaster/game-of-thrones/master/data/characters.json
; gerar charts
; gerar grafos
; salvar dados gerados em arquivos pdf

(def db (get-data))

(keys db)

(defn get-characters-from-episode [episode-scenes]
  (->> (map (fn [obj] (->> (:characters obj)
                           (map :name))) episode-scenes)
       (apply concat)
       (set)))


; grafo para visualizar quais personagens aparecem em certos episodios de certas temporadas
;                     game-of-thornes
;      season1                                season2
;      apisode1             episode1       episode2             episode3
;characterA characterB     characterA     characterC     characterD characterB

(defn get-episodes [db]
  (->> (:episodes db)
       (:data)
       (:episodes)))

;{:character-name screen-time}
; gráfico de barra com os personagens e seus screen time on the hole series
(as-> (get-episodes db) arg
      (map (fn [epsode]
             (as-> (:senes epsode) scene
                   scene)) arg))

(defn get-characters-from-scene [scene]
  (->> (:characters scene)
       (map :name)
       (set)
       (vec)))

(defn add-screen-time [character screen-time atom-map]
  (let [character (keyword character)]
    (if (contains? @atom-map character)
      (swap! atom-map #(assoc % character (+ (character %) screen-time)))
      (swap! atom-map #(assoc % character screen-time)))))

(defn add-characters-screen-time [characters screen-time atom-map]
  (map (fn [character]
         (add-screen-time character screen-time atom-map)) characters))

(def atom-map (atom {}))

(->> (get-episodes db)
     (map (fn [episode]
            (as-> (:scenes episode) scene
                  (let [[screen-time characters :as local-atoms] (map atom [0 nil])]
                    (->> (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                         (reset! screen-time))
                    (prn @screen-time)
                    (->> (get-characters-from-scene scene)
                         (reset! characters))
                    (prn @characters)
                    (add-characters-screen-time characters screen-time atom-map))))))

(comment (do (def atom-map (atom {}))
             (->> (get-episodes db)
                  (map (fn [episode]
                         (as-> (:scenes episode) scenes
                               (map (fn [scene] (let [[screen-time characters :as local-atoms] (map atom [0 nil])]
                                                  (->> (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                                                       (reset! screen-time))
                                                  (prn @screen-time)
                                                  (->> (get-characters-from-scene scene)
                                                       (reset! characters))
                                                  (prn @characters)
                                                  (add-characters-screen-time characters screen-time atom-map))) scenes)))))
             (prn @atom-map)
             (->> (get-episodes db)
                  (map (fn [episode] (as-> (:scenes episode) scenes
                                           (map (fn [scene] (do
                                                              (def screen-time (atom 0)) (def characters (atom [])) (def atom-map (atom {}))
                                                              (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                                                              (reset! screen-time (get-time-interval (:sceneStart scene) (:sceneEnd scene)))
                                                              (reset! characters (get-characters-from-scene scene))
                                                              (map (fn [character]
                                                                     (let [character (keyword character)]
                                                                       (println "print " @screen-time)
                                                                       (if (contains? @atom-map character)
                                                                         (swap! atom-map #(assoc % character (+ (character %) @screen-time)))
                                                                         (swap! atom-map #(assoc % character @screen-time))))) @characters))) scenes)))))
             (prn @atom-map)))

; this is working
(->> (get-episodes db)
     (map (fn [episode] (as-> (:scenes episode) scenes
                              (map (fn [scene] (do
                                                 (def screen-time (atom 0)) (def characters (atom [])) (def atom-map1 (atom {}))
                                                 (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                                                 (reset! screen-time (get-time-interval (:sceneStart scene) (:sceneEnd scene)))
                                                 (reset! characters (get-characters-from-scene scene))
                                                 (map (fn [character]
                                                        (let [character (keyword character)]
                                                          (if (contains? @atom-map character)
                                                            (swap! atom-map1 #(assoc % character (+ (character %) @screen-time)))
                                                            (swap! atom-map1 #(assoc % character @screen-time))))) @characters))) scenes)))))

; this is working
(let [characters-screen-time (atom {})]
  (->> (get-episodes db)
       (map (fn [episode]
              (->> (:scenes episode)
                   (map (fn [scene] (let [screen-time (atom 0) characters (atom [])])
                          (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                          (reset! screen-time (get-time-interval (:sceneStart scene) (:sceneEnd scene)))
                          (reset! characters (get-characters-from-scene scene))
                          (map (fn [character] (let [character (keyword character)])
                                 (if (contains? @characters-screen-time character)
                                   (swap! characters-screen-time #(assoc % character (+ (character %) @screen-time)))
                                   (swap! characters-screen-time #(assoc % character @screen-time))))) @characters)))))))

; this not working the (fn [episode] is not executing
(defn get-characters-screen-time [db return]
  (let [characters-screen-time (atom {})]
    (println "defn -> let")
    (as-> (get-episodes db) episodes
          (def temp episodes)
          (println "as->")
          (println temp)
          (map
            (fn [episode]
              (->> (:scenes episode)
                   (println "->>")
                   (map
                     (fn [scene]
                       (let [screen-time (atom 0) characters (atom [])]
                         (println "map -> fn -> let")
                         (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                         (reset! screen-time (get-time-interval (:sceneStart scene) (:sceneEnd scene)))
                         (reset! characters (get-characters-from-scene scene))
                         (map
                           (fn [character]
                             (let [character (keyword character)]
                               (println "map -> fn -> let")
                               (if (contains? @characters-screen-time character)
                                 ;(swap! characters-screen-time #(assoc % character (+ (character %) @screen-time)))
                                 ;(swap! characters-screen-time #(assoc % character @screen-time))
                                 (swap! characters-screen-time assoc character (+ (character characters-screen-time) @screen-time))
                                 (swap! characters-screen-time assoc character @screen-time))))



                           @characters))))))






            temp))


    (reset! return @characters-screen-time)))



(def return (atom {}))
(get-characters-screen-time db return)
(println @return)

(->> (get-episodes db)
     (map (fn [episode] (as-> (:scenes episode) scenes
                              (map (fn [scene] (do
                                                 (def screen-time (atom 0)) (def characters (atom [])) (def atom-map1 (atom {}))
                                                 (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                                                 (reset! screen-time (get-time-interval (:sceneStart scene) (:sceneEnd scene)))
                                                 (reset! characters (get-characters-from-scene scene))
                                                 (map (fn [character]
                                                        (let [character (keyword character)]
                                                          (if (contains? @atom-map character)
                                                            (swap! atom-map1 #(assoc % character (+ (character %) @screen-time)))
                                                            (swap! atom-map1 #(assoc % character @screen-time))))) @characters))) scenes)))))

;(get-episodes db)
;[{:scenes [{:sceneStart "0:00:40",
;            :sceneEnd "0:01:45",
;            :characters [{:name "Gared"} {:name "Waymar Royce"} {:name "Will"}]}]

(comment (let [[screen-time characters atom-map :as local-atoms] (map atom [nil nil nil])]
           (prn local-atoms)
           (prn @screen-time @characters @atom-map)
           (reset! screen-time "screen-time")
           (reset! characters "characters")
           (reset! atom-map "atom-map")
           (prn local-atoms)
           (prn @screen-time @characters @atom-map))

         (let [screen-time (atom "") characters (atom "") atom-map (atom "")]
           (prn @screen-time @characters @atom-map)
           (reset! screen-time "screen-time")
           (reset! characters "characters")
           (reset! atom-map "atom-map")
           (prn @screen-time @characters @atom-map)))


(comment (do
           (def atom-map (atom {}))
           (def characters ["antonio" "lucas" "samuel" "antonio"])
           (def characters-key (-> (map (fn [character] (keyword character)) characters)))
           (for [character characters-key]
             (if (contains? @atom-map character)
               (do
                 (prn "if")
                 (prn "before" @atom-map)
                 (swap! atom-map #(assoc % character (+ (character %) 10)))
                 (prn "after" @atom-map))
               (do
                 (prn "else")
                 (prn "before" @atom-map)
                 (swap! atom-map #(assoc % character 10))
                 (prn "after" @atom-map))))))

(def my-atom (atom {}))
(println @my-atom)
(defn change-my-atom [my-atom] (let [local-atom (atom {})]
                                 (swap! local-atom assoc :change1 1)
                                 (swap! local-atom assoc :change2 2)
                                 (swap! local-atom assoc :change1 (+ (:change1 @local-atom) 2))
                                 (reset! my-atom @local-atom)))
(change-my-atom my-atom)
(println @my-atom)


(defn testing-func [db return]
  (let [characters-screen-time (atom {})]
    (println "let")
    (do
      (def episodes (get-episodes db))
      (println "as->")
      (map (fn [] (println "map -> fn")) episodes))

    (reset! return @characters-screen-time)))



(defn testing-func []
  (let []
    (println "let")
    (do (println "do")
        (doall (map #(println "map -> fn" %) [1 2 3]))
        (doseq [v [1 2 3]] (println v))
        (println "end do"))
    (println "end let")))
(testing-func)

(macroexpand-1 '(map #(println "map -> fn" %) [1 2 3]))


; now it works the problem was the internal maps returned empty collections with just nil inside so clojure interpred as lazy sqe and it woul only execute code that returns lazy seq if it will use the values
(defn get-screen-time [db]
  (->> (get-episodes db)
       (map (fn [episode] (doall (as-> (:scenes episode) scenes
                                       (map (fn [scene] (let [screen-time (atom 0) characters (atom []) atom-map (atom {})]
                                                          (get-time-interval (:sceneStart scene) (:sceneEnd scene))
                                                          (reset! screen-time (get-time-interval (:sceneStart scene) (:sceneEnd scene)))
                                                          (reset! characters (get-characters-from-scene scene))
                                                          (map (fn [character] (let [character (keyword character)]
                                                                                 (if (contains? @atom-map character)
                                                                                   (swap! atom-map #(assoc % character (+ (character %) @screen-time)))
                                                                                   (swap! atom-map #(assoc % character @screen-time))))) @characters))) scenes)))))))

(def here (get-screen-time db))
(prn here)