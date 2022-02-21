(ns namespace-import.import-in-namespace-macro
; this is the namespace macro area
; all the import are generally used in here just lik im import.clj, but here does not use the ' literal for symbols
(:require [namespace-import.namespace1 :as ns1])
)

; show the current namespace we are
*ns*
(ns1/namespace1-func)
ns1/namespace1Map
