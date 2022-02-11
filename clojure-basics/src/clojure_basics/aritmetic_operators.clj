;; sum, + the is function the what comes after are parameters
(+ 2 2)
(+ 2 2 2)
(+ (+ 2 2) 2)

;; multiplying
(* 2 2)

;; division
(/ 5 6) ;; output 5/6
(/ 5. 6) ;; output 0.8333333333333334
(/ 5 5) ;; output 1
(/ 5 5 5 5) ;; output 1/25

;; clojure tries to avoid round numbers imprecision
(/ 5 6) ;; output 5/6 creates type called Ratio, its a type that prevents floats in math operations so a division between two integers that results in float will come out as Ratio
(/ 5. 6) ;; output 0.8333333333333334
;; u can force the result to not come as Ratio but as float 
(* (/ 5. 6) 6) ;; output 5.0
(* (/ 5 6) 6) ;; 5N, N means BigInt

;; subtraction
(- 1 2 3) 
;; when a function/math-operator receives more than the require parameters the following happens
;; execution goes subtract the two firts parameters 1 and 2
(- -1 3) 
;; now recursively call subtraction again, passing the result of the previous subtraction (- 1 2) with the next parameter 3, output -4

(mod 5 4)

;; type, will give the type of anything
(type 5N)
(type 5/6)
(type /)