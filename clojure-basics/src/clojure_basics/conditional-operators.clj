;; use boolean? to check if the value is actually boolean
(boolean? true)
(boolean? nil)

;; if statement
;; (if conditional-expression if-action else-action)
(if true true false)
(if false true false)
;; if any of conditional-expression, if-action or else-action are more complex then a simple value return they need to be wrapped in ()
(if (= 1 1) (= 1 1) (not= 1 1))
(if (= 1 2) (= 1 1) (not= 1 1))
;; the else-action can be empity, the else-action will return nil
(if true true)
(if false true)


(if true println "its true") ;; println goes as if-action and "its true" goes as else-action
(if true (println "its true")) ;; (println "its true") goes as if-action

;; in clojure for if statements only false and nil are logically false all the rest is logically true
(if nil true false)
(if false true false)
;; all true
(if 0 true false)
(if 1 true false)
(if [] true false)
(if () true false)
(if println true false)
(if (Object.) true false)

;; when its just like if but the else is always empity
;; (when conditional-expression if-true-action)
(when true true)
;; if u use more then one action it will execute all actions but will but the return will be only the last action
(when (== 1 1) (println "action 1"))
(when (== 1 1) (println "action 1") (println "action 2"))
(when (== 1 1) (println "action 1") (println "action 2") true)

;; do can be used to create same efect from when but using if
(if (== 1 1) (do (println "do action 1") (println "do action 2") true))

;; using case the default-action if not written it returns nil
;; case will only execute the first action and exit
;; (case variable-name
;;   value1 action1
;;   value2 action2
;;   default default-action
;; )
(def variable 1)
;; by default the operation used in case is the = operator
(case variable
  1. false
  1 true
)
;; using the default-action
(def variable2 2)
(case variable2
  1. false
  1 false
  true
)

;; cond like case but allow to use any operations besides =
;; case will only execute the first action and exit
(cond
  (> 2 1) "action 1"
  (= 1 1) "action 2"
)
