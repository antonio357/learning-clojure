(ns app.future_threads)

(defn my-pop [my-list]
  (let [l @my-list]
    (pop l)))

(defn sleep [seconds]
  (Thread/sleep (* seconds 1000)))

(defn take-supply [supply]
  (while (not (empty? @supply))
    (swap! supply disj (first @supply))
    (sleep 0.5)))

(def supply
  (->>
    (range 10)
    (apply sorted-set)
    (atom)))

(def print-loop
  (future
    (while true
      (println @supply)
      (sleep 0.5))))

(def threads
  (dorun
    (for [i (range 5)]
      (future
        (take-supply supply)))))

(sleep 4)
(for [i threads] (future-cancel i))
(future-cancel print-loop)

(println @supply)
