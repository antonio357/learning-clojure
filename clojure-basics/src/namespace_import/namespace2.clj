(ns namespace-import.namespace2)

(defn namespace2-func [] "namespace2-func")
(def namespace2Map {:namespace2-func "namespace2-func"})

(defn namespace2-not-imported-func [] "shoul not call it")