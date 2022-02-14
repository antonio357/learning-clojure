(> 1 -1)
(> 1 -1.)

(< -1 1)
(< -1 1.)

(>= 1 -1)
(>= 1 -1.)
(>= 1 1)
(>= 1 1.)

(<= -1 1)
(<= -1 1.)
(<= 1 1)
(<= 1 1.)

;; it compares the hole list of args
(> 1 -1. -1)
(> 1 -1. -2)

;; WARNNING: the equals operator = with diferent types
(= 1 1)
(= 1 1.)
;; instead use == 
(== 1 1)
(== 1 1.)

(= 1 \1)
(= 1. \1)
(== 1 \1) ;; does not execute
(== 1. \1) ;; does not execute

(= 1 "1")
(= 1. "1.")
(== 1 "1") ;; does not execute
(== 1. "1.") ;; does not execute

;; Symbol type '1 works like Int type 1 
(= 1 '1)
(== 1 '1)
(= 1. '1)
(== 1. '1)
(= 1 '1.)
(== 1 '1.)
(= 1. '1.)
(== 1. '1.)

;; WARNNING: >== or <== does not exists in clojure