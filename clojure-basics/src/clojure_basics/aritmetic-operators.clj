;  sum, + the is function the what comes after are parameters
(+ 2 2)
(+ 2 2 2)
(+ (+ 2 2) 2)

;  multiplying
(* 2 2)

;  division
(/ 5 6) ;  output 5/6
(/ 5. 6) ;  output 0.8333333333333334
(/ 5 5) ;  output 1
(/ 5 5 5 5) ;  output 1/25

;  clojure tries to avoid round numbers imprecision
(/ 5 6) ;  output 5/6 creates type called Ratio, its a type that prevents floats in math operations so a division between two integers that results in float will come out as Ratio
(/ 5. 6) ;  output 0.8333333333333334
;  u can force the result to not come as Ratio but as float 
(* (/ 5. 6) 6) ;  output 5.0
(* (/ 5 6) 6) ;  5N, N means BigInt

;  subtraction
(- 1 2 3) 
;  when a function/math-operator receives more than the require parameters the following happens
;  execution goes subtract the two firts parameters 1 and 2
(- -1 3) 
;  now recursively call subtraction again, passing the result of the previous subtraction (- 1 2) with the next parameter 3, output -4

;  remainer of division, mod and rem
(rem 3 2)
(mod 3 2)
;  WARNNING: (rem - +) returns - but (rem + -) returns + 
(rem -3 2) 
(rem 3 -2)  
;  WARNNING: (mod - +) returns + but (mod + -) returns -  
(mod -3 2)
(mod 3 -2)
;  WARNNING: (mod - -) returns - and (rem - -) returns -
(mod -3 -2)
(rem -3 -2)
;  WARNNING: for the given the problems listed above use quot instead
;  (quot + +) returns +, (quot + -) returns -, (quot - +) returns -, (quot - -) returns +,
(quot 3 2)
(quot 3 -2)
(quot -3 2)
(quot -3 -2)
;  WARNNING: but if u need remainer of num / num do not use quot, cause (quot num num) returns 1
(quot 1 1)
(quot -1 -1)


(inc 1) ;  in C 1++
(dec 1) ;  in C1--

(max 1 2 3)
(min -1 -2 -3)

;  type, will give the type of anything
(type 5N)
(type 5/6)
(type /)