(ns app.core
  (:require [clojure.string :as str])
  (:require [clojure.data.json :as json]))

; consumir a api https://raw.githubusercontent.com/jeffreylancaster/game-of-thrones/master/data/characters.json

(def urls {
            :github "https://github.com/jeffreylancaster/game-of-thrones/tree/master/data"
            :github-content "https://raw.githubusercontent.com/jeffreylancaster/game-of-thrones/master/data/"})

(defn get-data-links [urls]
  (as-> (:github urls) variable ; gets url
    (slurp variable) ; page request
    (re-seq #"data/.*.json\">" variable) ; get the links
    (map (fn [string] (str/replace string #"data/|.json\">" "")) variable) ; get only the content string
    [(map keyword variable) variable] ; [[keys] [values]]
    (zipmap (variable 0) (variable 1)))) ; map from [keys] [values]

(def data-links (get-data-links urls))
(prn data-links)

(as-> (keys data-links) arg
      (take 1 arg)
      (map (fn [k] [k (str (:github-content urls) ((keyword k) data-links) ".json")]) arg)
      (map (fn [item] (conj item (slurp (item 1)))) arg)
      (map (fn [item] (assoc item 2 (json/read-str (item 2) :key-fn keyword))) arg)
      [(map (fn [item] (item 0)) arg) (map (fn [item] {:url (item 1) :data (item 2)}) arg)]
      (zipmap (arg 0) (arg 1)))



