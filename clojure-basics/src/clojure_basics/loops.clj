
; be carefull with while loops do not remenber bindings are immutable so dec will return a new counter
(def counter 10)
(while (pos? counter)
  (println counter)
  (dec counter)
) ; this is an infinite loop
; the correct way
(def counter (atom 10))
(while (pos? @counter)
  (println @counter)
  (swap! counter dec)
)

; loop function, uses local variables as parameter 
; (loop [variable-name initial-value] action (coditional-expression recur)) 
(loop [loop-counter 10]
  (println loop-counter)
  (when (pos? loop-counter) (recur (dec loop-counter)))
)
(loop [loop-counter 10 loop-counter1 12]
  (println loop-counter loop-counter1)
  (when (or (pos? loop-counter) (pos? loop-counter1)) (recur (dec loop-counter) (dec loop-counter1)))
)

; for, uses local variable as parameter
; (for [variable-name collection])
(for [i [1 2 3]]
  (println i)
)
; generates all combinations
(for [i [0 1] x [0 1]]
  (println i x)
)