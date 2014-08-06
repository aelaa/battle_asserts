(ns battle-solutions.stack-test
  (:require [clojure.test :refer :all]
            [battle-asserts.test-helper :refer [assert-equal]]))

(ns-unmap *ns* 'pop)

(defprotocol Stackable
  (pop [this] [this cnt])
  (push [this obj]))

(defrecord Stack [value]
  Stackable
  (pop [this]
        (let [obj (:value this)
              el (peek @obj)]
          (reset! obj (clojure.core/pop @obj))
          (long el)))
  (pop [this cnt]
        (vec (take cnt (repeatedly #(.pop this)))))
  (push [this obj]
        (swap! (:value this) clojure.set/union obj)))

(deftest test-asserts
  (let [stack (Stack. (atom [5 6 7 8]))]
    (assert-equal 8 (.pop stack))
    (assert-equal 7 (.pop stack))
    (assert-equal [5 6 4 2] (.push stack [4 2]))
    (assert-equal [2 4 6] (.pop stack 3))))
