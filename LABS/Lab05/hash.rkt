#lang racket

(define ht (hash 'a 1 'b 2))

(hash-ref ht 'a)
(hash-ref ht 'c 0) ;; if the 3rd argument is ommitted, this will be an error

(define ht2 (hash-set ht 'c 42))
(hash-ref ht2 'c 0)
(hash-ref ht 'c 0)