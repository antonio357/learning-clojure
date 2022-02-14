;; defn to create functions
;; (defn function-name [parameters]
;;  return
;; )

(defn sum [a b]
  (+ a b)
)
(sum 1 2)

(defn pow2 [num]
  (* num num)
)
(pow2 2)

;; anonimous functions can be created with fn and it can be assigned to a variable using def
(def sub (fn [a b] (- a b)))
(sub 1 2)

;; use ifn? to check if anything is a function that can be called
(ifn? sum)
(ifn? pow2)

;; recursion

;; in standard functions
(defn itsPowerOf2 [num] 
  (if (> num 2) (itsPowerOf2 (/ num 2)) (if (== num 2) true false))
)
(itsPowerOf2 16)

;; in anonymous functions we use recur since we hava no name to call
((fn [num] (if (> num 2) (recur (/ num 2)) (if (== num 2) true false))) 8)