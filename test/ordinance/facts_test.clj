(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest bogota-has-spec-basis
  (let [sb (facts/spec-basis "bogota")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://secretariageneral.gov.co/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "mexico-city")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["bogota" "mexico-city"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["mexico-city"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["bogota.acuerdo-001-2026-autenticacion-digital"]
         (mapv :ordinance/id (facts/by-topic "bogota" :technology-standards))))
  (is (empty? (facts/by-topic "bogota" :labor)))
  (is (empty? (facts/by-topic "mexico-city" :governance))))
