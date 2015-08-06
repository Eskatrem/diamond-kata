(ns diamond-kata.core)

(defn make-regexp [chr]
  (re-pattern (str "[^" chr "]")))

(defn line-with-spaces [chr line]
  (let [re (make-regexp chr)]
    (clojure.string/replace line re " ")))

(defn get-number [chr]
  (- (int (first (seq chr))) 65))

(defn get-char [val] (str (char (+ 65 val))))

(defn get-chars [chr]
  (let [n (get-number chr)]
    (map get-char (concat (range (+ 1 n)) (range (- n 1) -1 -1)))))

(defn get-number-spaces [n]
  (if (= n 1) 0
      (- (* 2 n) 1)))

(defn repeat-char [n chr]
  (apply str (take n (repeat chr))))

(defn get-line [chr]
  (if (= chr "A") "A"
      (let [n (get-number chr)
            p (get-number-spaces n)]
        (str chr (repeat-char p " ") chr))))

(defn generate-line [chr]
  (let [n (get-number chr)]
    (str (apply str (map get-char (range n -1 -1))) (apply str (map get-char (range 1 (+ 1 n)))))))

(defn generate-lines [chr]
  (let [n (get-number chr)
        line (generate-line chr)]
    (take (+ (* 2 n) 1) (repeat line))))





(defn make-diamond [letter]
  (let [lines (generate-lines letter)
        chars (get-chars letter)]
    (map line-with-spaces chars lines)))

(defn print-diamond [letter]
  (doseq [x (make-diamond letter)] (println x)))

(defn foo
  
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


