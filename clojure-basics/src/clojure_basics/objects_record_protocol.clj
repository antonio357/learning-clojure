; in clojure we can not assign a function to a map and try to make something like objects
(def mapA {:func (fn [] println "ok")})
(mapA) ; deos not works

; instead we can use records wich is jusk like a map, but with the object point o view, where u can have predefined keys for values like attributes and protocols that can acess thesse "attributes" like methods

; https://www.youtube.com/watch?v=xpH6RGjZwNg&ab_channel=onthecodeagain
