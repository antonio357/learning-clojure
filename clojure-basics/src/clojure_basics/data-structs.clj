; structs

(def person (create-struct :name :age))
(def antonio (struct person "Antonio" 22))
(type antonio)
(keys antonio)
(vals antonio)
(println antonio)
(:name antonio)
(antonio :age)