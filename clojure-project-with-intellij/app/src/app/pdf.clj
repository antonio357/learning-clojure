(ns app.pdf
  (:require [clj-pdf.core :refer [pdf]]))

(defn- get-dir [name]
  (str "output/pdf/" name ".pdf"))

(defn write-pdf [content, name]
  (pdf [{} content] (get-dir name)))

(pdf
  [{}
   [:list {:roman true}
    [:chunk {:style :bold} "a bold item"]
    "another item"
    "yet another item"]
   [:phrase "some text"]
   [:phrase "some more text testing"]
   [:paragraph "yet more text"]
   [:line]]
  (get-dir "doc"))

(def a (list [] []))
(prn a)


(pdf
  [{}
   [:chart
    {:type "bar-chart"
     :title "Bar Chart"
     ;:background [10 100 40]
     :x-label "Items"
     :y-label "Quality"}
    [2 "Foo"] [4 "Bar"] [10 "Baz" ]]]
  (get-dir "doc"))

