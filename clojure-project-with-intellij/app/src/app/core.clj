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

(defn get-db [data-links]
  (as-> (keys data-links) arg
        (take 3 arg)
        (map (fn [k] [k (str (:github-content urls) ((keyword k) data-links) ".json")]) arg)
        (map (fn [item] (conj item (slurp (item 1)))) arg)
        (map (fn [item] (assoc item 2 (json/read-str (item 2) :key-fn keyword))) arg)
        [(map (fn [item] (item 0)) arg) (map (fn [item] {:url (item 1) :data (item 2)}) arg)]
        (zipmap (arg 0) (arg 1))))

(def data-links (get-data-links urls))
(def db (get-db data-links))

(-> (keys db)
    (last)
    (db)
    (:data))

(def test-map (-> (keys db)
                  (last)
                  (db)
                  (:data)))

(defn my-print [value]
  (prn)
  (try (prn value)))

(defn get-data-struct [data, data-struct]
  (if (map? data)
    (for [k (keys data)] (->> (get-data-struct (k data) (k data-struct)) (assoc data-struct k)))
    (if (coll? data)
      (for [v data] (->> (get-data-struct v data-struct) (conj data-struct)))
      (class data))))

(prn test-map)
(def data-struct (get-data-struct test-map (empty test-map)))
(prn test-map)
(prn data-struct)





