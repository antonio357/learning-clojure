;; defn to create functions
;; (defn function-name
;;   [parameters]
;;   ;; return
;; )

(defn sum
  [a b]
  (+ a b)
)
(sum 1 2)

(defn pow2
  [num]
  (* num num)
)
(pow2 2)

;; anonimous functions can be created with fn
(def sub (fn [a b] (- a b)))
(sub 1 2)

;; use ifn? to check if anything is a function 
(ifn? sum)
(ifn? pow2)
