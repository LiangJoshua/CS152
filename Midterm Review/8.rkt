#lang racket
(provide mycond)
(define (mycond cond thn els)
  (if cond cond) thn els))

(define x 3)

(mycond
    (= x 3)
    (displayln "x is 3")
    (displayln "x is NOT 3")

)