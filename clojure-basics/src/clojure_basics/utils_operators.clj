; clojure threading macros https://www.youtube.com/watch?v=vw4ShJ2_Vj8&ab_channel=onthecodeagain

; threads macro are used to organize code
; lets say we have the following array with grades
(def grades [10 10 10 10 10 10])
; and from this array whe want to create a function to return the average
(defn get-average [grades]
  (/ (reduce + grades) (count grades))
) 

(def personName {:firstName "antonio" :secondName " carlos" :thirdName " albuquerque" :fourthName " alves"})

(defn concat-print [string1 string2]
  (def finalString (str string1 string2))
  (println finalString)
  finalString
)

; whithout threading macro the order of executiong goes from bottom to top, from the most inner function to the last, so u have to reverse read it 
(defn print-full-name [personName]
  (concat-print (personName :firstName) 
    (concat-print (personName :secondName) 
      (concat-print (personName :thirdName) (personName :fourthName))
    )
  )
)
(print-full-name personName)

; with threading macro
(defn print-full-name-with-thread-macro [personName]
  (-> 
    (concat-print (personName :firstName) (personName :secondName))
    (concat-print (personName :thirdName))
    (concat-print (personName :fourthName))
  )
)

; ->, thread first
; ->>, thread last
; as->
; cond->
; some->








; -> ->> % %1 %2 %3 *