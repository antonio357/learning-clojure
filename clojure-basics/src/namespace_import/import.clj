
; imports all things with public access from namespace1.clj
(use 'namespace-import.namespace1)
(namespace1-func)
namespace1Map
(namespace1-can-not-be-imported)
-namespace1Map-can-not-be-imported

; with :only, imports certain things from namespace2.clj
(use '[namespace-import.namespace2 :only [namespace2-func namespace2Map]])
(namespace2-func)
namespace2Map
;; (namespace2-not-imported-func)

; with :exclude, imports all things from namespace3.clj exept what is in exclude
(use '[namespace-import.namespace3 :exclude [namespace3-func namespace3Map]])
(namespace3-func)
namespace3Map
(namespace3-not-imported-func)


; normally it is used require
(require '[namespace-import.namespace4]) ; executes but does not works since u have no reference to namespace-import.namespace4
; now it works, but imports only certain things within :refer
(require '[namespace-import.namespace4 :refer [namespace4-func namespace4Map]])
(namespace4-func)
namespace4Map

; to import everything with require
(require '[namespace-import.namespace5 :as ns5])
(ns5/namespace5-func)
(ns5/namespace5-func1)
ns5/namespace5Map 