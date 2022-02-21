; check all the explanation https://www.youtube.com/watch?v=0if71HOyVjY&ab_channel=GOTOConferences
; atoms are a solution to side effects
; atoms are the closest thing from variables in clojure since the data structs in clojure are immutable (they threes with nodes and the leafs are values)
; atom is a memory information with u can throw a function inside and the function will take the atom as argument and make some processing without changing the atom at the end of the function execution the function will handle a new value to the atom so it can update its value
; ok so if u have more than one function thrown in the atom both will execute in parallel on them will change deliver the new value for atom first then the second function will be notified that the atom was updated so it will execute agin with the new value from the atom
; in this way we avoid lockers and deadlocks and still execute parallelism

; most mutable data type in clojure, its thread-safe

; create a atom (atom initial-value)
(def name (atom "antonio"))
; access atom value @atom 
@name
; change atom value
; with swap, (swap! atom function function-args)
(swap! name str " " "albuquerque")
; the function is called like (function atom-arg function-args) and the returned value is thrown into the atom
(println @name)
; with reset!, (reset! atom new-value)
(reset! name "antonio")

; validator
; u can create an atom with a validator
(def myAtom (atom -1 :validator pos?)) ; it will not work because the validator only allows positive numbers
(def myAtom (atom 1 :validator pos?))
@myAtom
(reset! myAtom -1) ; every time it tries to change the value of the atom it will only allow if the validator return true