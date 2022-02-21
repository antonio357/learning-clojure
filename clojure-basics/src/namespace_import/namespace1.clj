; ns as the frist function call of a file to declare its namespace
; (ns dir.file-name), it has to be the same name of the file
; note that the directory of the name is clojure_basics with _ but it gets turned into -
; so it goes as namespace-import
; WARNNING: for directories and files names u have to use _ to separate the words do not use - it will not compile
(ns namespace-import.namespace1)

(defn namespace1-func [] "namespace1-func")
(def namespace1Map {:namespace1-func "namespace1-func"})

; private things are not can not be imported from others files
; to make a function private use defn-
(defn- namespace1-can-not-be-imported [] "can not call it from other file")
(def ^:private namespace1Map-private {:namespace1Map-private "namespace1Map-private"})
namespace1Map-private
