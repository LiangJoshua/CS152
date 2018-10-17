#lang racket

(require "big-num.rkt")

;; Crude workaround to split math expressions easily
(define (bc-split exp)
  (string-split
   (string-replace
    (string-replace
     (string-replace
      (string-replace exp "+" " + ")
      "-" " - ")
     "*" " * ")
    "^" " ^ ")))

;; Very simple parser
(for ([l (in-lines)])
  (let ([words (bc-split l)])
    (if (not (= 3 (length words)))
        (display "Complex expressions not supported")
        (let
            ([arg1 (string->bignum (car words))]
             [op (cadr words)]
             [arg2 (string->bignum (caddr words))])
          (display (cond
            [(string=? op "+") (pretty-print (big-add arg1 arg2))]
            [(string=? op "-") (pretty-print (big-subtract arg1 arg2))]
            [(string=? op "*") (pretty-print (big-multiply arg1 arg2))]
            [(string=? op "^") (pretty-print (big-power-of arg1 arg2))]
            [else "Not supported"]))))
  (newline)))
