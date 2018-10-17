#lang racket
(provide mult-all)
(define (mult-all lst)
  (foldr
   (lambda (x y) (* x y))
   1
   lst))

