(ns battle-solutions.missing-number-test
  (:require [clojure.test :refer :all]
            [battle-asserts.test-helper :refer :all]))

(defn missing-number
  [lst]
  (let [x (/ (-
              (last lst)
              (first lst))
             (count lst))]
    (-
     (->> lst
          first
          (iterate #(+ % x))
          (take (inc (count lst)))
          (reduce +))
     (reduce + lst))))

(deftest test-asserts
  (let [input [1 3 5 9 11 13 15]]
    (assert-equal 7 (missing-number input))))
