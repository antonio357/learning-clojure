;; clojure is dynamic typed
;; variables, clojure does not realy have variables since this variables are immutable, 
;; to change the value of a "variable" it will destry the viariable and create a new one with the new value
;; variables here are more like value bound to a memory piece

;; to create a variable use def keyword
;; (def variable-name value)
(def variable "value")
(println variable)

;; scalar variables types
;; boolean
(def aBoolean true)
(type aBoolean)
(println aBoolean)
;; numeric
(def aShort 1)
(type aShort)
(println aShort)
(def aInt 1000)
(type aInt)
(println aInt)
(def aLong 1000000000)
(type aLong)
(println aLong)
(def aFloat 1.)
(type aFloat)
(println aFloat)
;; alphanumeric
(def aChar \c)
(type aChar)
(println aChar)
;; in clojure use " to create Strings not ' as it defnines symbol type
(def aString "string")
(type aString)
(println aString)
(def aSymbol 's)
(type aSymbol)
(println aSymbol)

