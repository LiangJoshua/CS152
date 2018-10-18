#lang racket
(define-syntax while
 (syntax-rules ()
 [(while cond body ...)
 (let loop ()
 (when cond
 body ...
 (loop)))]))

(let ([x 5])
(while (> x 0)
(displayln x)
(set! x (- x 1))))