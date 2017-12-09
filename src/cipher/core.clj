(ns cipher.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn pluxValues [x y]
  (+ x y 100))

(defn times10PlusY [x y]
  (+(* x 10) y))

(defn to-int
  "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  "takes a number between 0 and 25 (inclusive) and returns the corresponding lowercase letter."
  [int-char]
  (let [int-lower-base 97
        lower (+ int-char int-lower-base)]
    (char lower)))
(defn shift
  "shifting the alphabet by a given number of positions to the left"
  [letter, positions]
  (let [int-letter (to-int letter)
        int-shift (+ int-letter positions)
        int-mod (mod int-shift 26)]
       (to-char int-mod)))

(defn caesar-encrypt
  "Encrypting word sequence"
  [word positions]
  (apply str (mapv #(shift % positions) word)))

(defn caesar-decrypt
  "Decrypting word sequence"
  [word positions]
  (let [ revert-pos (* -1 positions)]
    (apply str (mapv #(shift % revert-pos) word))))











