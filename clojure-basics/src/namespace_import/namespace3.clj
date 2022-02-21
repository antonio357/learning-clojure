(ns namespace-import.namespace3)

(defn namespace3-func [] "namespace3-func")
(def namespace3Map {:namespace3-func "namespace3-func"})

(defn namespace3-not-imported-func [] "shoul not call it")