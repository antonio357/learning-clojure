(ns namespace-import.namespace5)

(defn namespace5-func [] "namespace5-func")
(defn namespace5-func1 [] "namespace5-func1")
(def namespace5Map {:namespace5-func "namespace5-func"})

(defn- namespace5-can-not-be-imported [] "can not call it from other file")