(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest bogota-has-culture-basis
  (let [sb (facts/spec-basis "bogota")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "bogota" (:culture/municipality %)) sb))
    (is (every? #(= "COL" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "medellin")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["bogota" "medellin"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["medellin"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 3 (count (facts/by-kind "bogota" :dish))))
  (is (= ["bogota.beverage.chicha"]
         (mapv :culture/id (facts/by-kind "bogota" :beverage))))
  (is (empty? (facts/by-kind "bogota" :craft)))
  (is (empty? (facts/by-kind "medellin" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
