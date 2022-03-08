(ns clojure-basics.core-test
  (:require [clojure.test :refer :all]
            [clojure-basics.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))



(println new-var)
(defn create-new-var [] (def new-var "new-var"))
(println new-var)
(create-new-var)
(println new-var)

(println new-var1)
(defn create-new-var1 [] (do (def new-var1 "new-var1") nil))
(println new-var1)
(create-new-var1)
(println new-var1)


(defn testing-func []
  (let []
    (println "let")
    (do (println "do")
        (map (fn [] (println "ok")) [1 2 3])
        (println "end do"))
    (println "end let")))
(testing-func)


