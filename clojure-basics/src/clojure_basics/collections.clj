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

;; set
(type {1 2})
(def setA {1 2})
(set? setA)
setA
(def setB {1 2 1}) ;; repeated elements thorws exeptions

;; sequences

;; sorted collections

;; basics operations with collections

;; add

;; remove

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
