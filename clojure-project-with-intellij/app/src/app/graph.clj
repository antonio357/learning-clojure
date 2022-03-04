(ns app.graph
  (:require [aerial.hanami.common :as hc]
            [aerial.hanami.templates :as ht]
            [aerial.hanami.core :as hmi]))


(let [cljspec spec
      udata (cljspec :usermeta)
      default-frame {:top [], :bottom [],
                     :left [[box :size "0px" :child ""]],
                     :right [[box :size "0px" :child ""]]}]
  (cond
    ...
    (udata :slider)
    (let [sval (rgt/atom "0.0")]
      (printchan :SLIDER-INSTRUMENTOR)
      (merge default-frame
             {:top (xform-recom
                     (udata :slider)
                     :m1 sval
                     :oc1 #(do (bar-slider-fn tabid %)
                               (reset! sval (str %)))
                     :oc2 #(do (bar-slider-fn tabid (js/parseFloat %))
                               (reset! sval %)))}))))