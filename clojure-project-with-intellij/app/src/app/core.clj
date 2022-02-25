(ns app.core
  (:require [app.getData :refer [get-data]]))

; pegar dados da api https://raw.githubusercontent.com/jeffreylancaster/game-of-thrones/master/data/characters.json
; gerar charts
; gerar grafos
; salvar dados gerados em arquivos pdf

(def db (get-data))

(keys db)

(defn get-characters-from-episode [episode-scenes]
  (->>(map (fn [obj] (->> (:characters obj)
                          (map :name))) episode-scenes)
      (apply concat)
      (set)))


; grafo para visualizar quais personagens aparecem em certo episodio
;                     game-of-thornes
;      season1                                season2
;      apisode1             episode1       episode2             episode3
;characterA characterB     characterA     characterC     characterD characterB
(->> (:episodes db)
    (:data)
    (:episodes))




