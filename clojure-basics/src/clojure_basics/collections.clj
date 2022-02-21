;  in clojure the collections are thread-safe
;  collections supports:
;  count check the how mant items are in the collection
;  conj to create a new collection with the new itens
;  seq to iterate thtough the collection

; to check if something is a collection use the coll? functions
(coll? 1)
(coll? [1 2])

;  vectors
[1 2 3 4]
(vector 1 2 3 4)
(println [1 2 3 4])
(def v [1 2. 2/3 \a 's "str"])
(type v)
;  use vector? to check if its a vector
(vector? v)

;  use vec to convert things to vector
(def v1 (vec "str"))
v1
(type v1)

;  list
(def listA '(1 2 3))
(def listB '(1 (+ 1 1) 3)) ;  (+ 1 1) will be interpreted as a symbol not 2
listA
listB
(type listA)
(type listB)
(def listC (list 1 2 3))
(def listD (list 1 (+ 1 1) 3)) ;  (+ 1 1) will be interpreted as 2 not a symbol
listC
listD
(type listC)
(type listD)

;  operations with vectors and lists
(v 0)
(v1 (- (count v1) 1))
(get v 0)
(first listC)


;  map, use : to determine a key for the value inside a map
(type {:ele1 1 :ele2 2})
(def mapA {:ele1 1 :ele2 2})
(map? mapA)
(def mapB (array-map :1 1 :2 2))
(def mapC (hash-map :1 1 :2 2))
(type mapB)
(type mapC)

;  set use the literal #, if you do not use # it will return a map
(type {1 2})
(type #{1 2})
(def setA #{1 2})
(set? setA)
setA
(def setB #{1 2 1}) ;  repeated elements thorws exeptions

;  sequences, are a type of collection that can be created from any collection type, and its purpuse is to get a sequencial view of a data struct
(seq [])
(seq [1 2 3])
(def seqA [1 2 3])
(type seqA)
(type (seq '(1 2 3)))

;  sorted collections

;  basics operations with collections

;  add
;  conj can add elements to a collection but does not especify order it depends on the collections, it uses the most effiienty way to add te element in the given collection, so if it's a list it will add in the begininig if is a vector it will add at the end
(conj [1 2 3] 4 5)
(conj (list 1 2 3) 0)
(conj {:e1 1 :e2 2} [:e3 3])
(conj #{1 2} 3 4)
; cons adds elements to the beginning but also converts the collection to a list, cons element collection
(cons 1 [2 3])
(cons 1 '(2 3))
(cons 1 #{2 3})
(cons [:1 1] {:2 2 :3 3})
;  for vectors and maps use assoc, assoc collection index value
;  assoc can update or add
;  in vectors assoc will add at the end of the vector only any other index it will update the value
(assoc [1 2] 2 3) ;  it will add 3
(assoc [2 3] 0 1) ;  it will update the value in index 0
(assoc [1 3] 1 2) ;  it will update the value in index 1
(assoc {:1 1 :2 2} :3 3)

;  remove
;  lists and vectors use pop or remove
(pop [1 2 3]) ;  removes from the end
(pop (list 1 2 3)) ;  removes from the beginning
;  remove, receves a function that will return true for the elements that are to be removed from the collection and false to the elements that are to stay in the collection
(remove neg? #{-1 2 3})
(remove pos? [-1 -2 3])
;  for sets use disj
(disj #{1 2 3} 1 2)
;  for maps use dissoc
(dissoc {:1 1 :2 2 :3 3} :1 1 :2 2)
(dissoc {:1 1 :2 2 :3 3} :1 :2)

; built-in functions to collections
;  map, filter, remove, take, and drop
;  count conj empty? seq
;  first rest next 
;  empty contains assoc dissoc
(first mapA)
(last mapA)
(count mapA)
; concat concatenate collections but return a list
(concat [1 2] [3 4])
(concat '(1 2) '(3 4))
(concat #{1 2} #{3 4})
(concat {:1 1 :2 2} {:3 3 :4 4})
(concat [1 2] #{1 2})
(concat {:1 1 :2 2} [3 4])
; to check if a collection is empty?
(empty? [])
(empty? [[]]) ; returns false
(empty? '())
(empty? #{})
(empty? #{#{}}) ; returns false
(empty? {})
; create a collection from another collection with into
(into [] '(1 2 3))
(into '() [1 2 3])
(into #{1 2 3} #{4 5 6})
