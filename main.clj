(defn isPrime?[n]
(let [divisors (range 2(inc (int (Math/sqrt n))))
remainders(map #(mod n %) divisors)]
(not-any? #(= % 0) remainders)
))

(defn nPrimes ([n](take n (filter isPrime? (iterate inc 2))))
([n f] (map f (nPrimes n))))

(defn nPrimes2 (
  [n](
    ->>(iterate inc 2)
    (filter isPrime?)
    (take n)))
    ([n f] (->> (nPrimes2 n)
    (map f)))
    )

(nPrimes2 1000)