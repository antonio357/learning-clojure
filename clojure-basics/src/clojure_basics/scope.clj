; functions scope

; global scope
(def global-a "global a")

; function local scope, here the only bind that is local is the parameters of the function
(defn func [param]
  (def local-a "func local a")
  (println (str local-a global-a param)))


(println global-a) ; works
(func "param string")
(println local-a) ; it works because def will always create a global bind

; so to actually create local bind s use let function
(def global-b "global b")

; function local scope, now loca-b and local-c are actually local just like the parameters
; (let [local-bind value] action-that-can-access-to-the-local-binds)
(defn func-b [param]
  (let [local-b "func local b" local-c "func local c"]
    (println (str local-b global-b param))
    (println local-c))) ; it works
(defn func-c [param]
  (let [local-b "func local b" local-c "func local c"]
    (println (str local-b global-b param)))
    (println local-c)) ; it does not works because let binds only exits inside its let () defn is not creating a scope only let is creating a scope


(println global-b) ; works
(func-b "param string")
(println local-b) ; it does not works anymore