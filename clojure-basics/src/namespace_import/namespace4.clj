(ns namespace-import.namespace4)

(defn namespace4-func [] "namespace4-func")
(def namespace4Map {:namespace4-func "namespace4-func"})

(defn namespace4-not-imported-func [] "shoul not call it")
(defn- namespace5-can-not-be-imported [] "can not call it from other file")