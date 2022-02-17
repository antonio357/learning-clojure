;; in clojure the collections are thread-safe
;; collections supports:
;; count check the how mant items are in the collection
;; conj to create a new collection with the new itens
;; seq to iterate thtough the collection

;; vectors
[1 2 3 4]
(vector 1 2 3 4)
(println [1 2 3 4])
(def v [1 2. 2/3 \a 's "str"])
(type v)
;; use vector? to check if its a vector
(vector? v)

;; use vec to convert things to vector
(def v1 (vec "str"))
v1
(type v1)

;; list
(def listA '(1 2 3))
(def listB '(1 (+ 1 1) 3)) ;; (+ 1 1) will be interpreted as a symbol not 2
listA
listB
(type listA)
(type listB)
(def listC (list 1 2 3))
(def listD (list 1 (+ 1 1) 3)) ;; (+ 1 1) will be interpreted as 2 not a symbol
listC
listD
(type listC)
(type listD)

;; operations with vectors and lists
(v 0)
(v1 (- (count v1) 1))
(get v 0)
(first listC)


;; map, use : to determine a key for the value inside a map
(type {:ele1 1 :ele2 2})
(def mapA {:ele1 1 :ele2 2})
(map? mapA)
(def mapB (array-map :1 1 :2 2))
(def mapC (hash-map :1 1 :2 2))
(type mapB)
(type mapC)

;; set use the literal #, if you do not use # it will return a map
(type {1 2})
(type #{1 2})
(def setA #{1 2})
(set? setA)
setA
(def setB #{1 2 1}) ;; repeated elements thorws exeptions

;; sequences, are a type of collection that can be created from any collection type, and its purpuse is to get a sequencial view of a data struct
(seq [])
(seq [1 2 3])
(def seqA [1 2 3])
(type seqA)
(type (seq '(1 2 3)))

;; sorted collections

;; basics operations with collections

;; add
;; conj can add elements to a collection but does not especify order it depends on the collections, it uses the most effiienty way to add te element in the given collection, so if it's a list it will add in the begininig if is a vector it will add at the end
(conj [1 2 3] 4 5)
(conj (list 1 2 3) 0)
(conj {:e1 1 :e2 2} [:e3 3])
(conj #{1 2} 3)

;; remove
;; use pop for lists and vectors
(pop [1 2 3]) ;; removes from the end
(pop (list 1 2 3)) ;; removes from the beginning
(disj )


;; update

;; get

;; map, filter, remove, take, and drop
;; count conj empty? seq
;; first rest next 
;; empty contains assoc dissoc
(first mapA)
(last mapA)
(count mapA)

;; goes for nuilt in functions
