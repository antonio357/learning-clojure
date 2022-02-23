; structs
; a struct is like a map but with predefined keys, so every time u create a struct iit will come with the predifined keys even if its values are nil

(def person (create-struct :name :age))
(def person-no-values (struct person))
person-no-values
(def antonio (struct person "Antonio" 22))
(type antonio)
(keys antonio)
(vals antonio)
(println antonio)
(:name antonio)
(antonio :age)