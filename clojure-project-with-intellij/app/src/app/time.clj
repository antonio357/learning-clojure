(ns app.time)

(defn- parse-seconds [time-stamp]
  (as->
    (clojure.string/split time-stamp #":") time-stamp
    (map #(Integer/parseInt %) time-stamp)
    (vec time-stamp)
    (+
      (* (time-stamp 0) 60 60)
      (* (time-stamp 1) 1 60)
      (time-stamp 2))))

(defn get-time-interval [time-stamp-begin time-stamp-end]
  (let [time-stamp-begin (parse-seconds time-stamp-begin) time-stamp-end (parse-seconds time-stamp-end)]
    (as-> (- time-stamp-end time-stamp-begin) interval
        (if (< interval 0) (* interval -1) interval))))
