(ns battle-solutions.titleize-test
  (:require [clojure.test :refer :all]
            [battle-asserts.test-helper :refer :all]
            [clojure.string :as string]))

(defn titleize
  [string]
  (join " " (map string/capitalize (string/split string #" "))))

(deftest test-asserts
  (let [input "alice in wonderland"
        output "Alice In Wonderland" ]
    (assert-equal output (titleize input))))
