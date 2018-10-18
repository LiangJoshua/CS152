#lang racket
#lang racket
PROBLEM 10
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



PROBLEM 11
#lang racket
(define (sorted? lst)
  (if (<= (length lst) 2)
      #t
    (and (>= (car lst) (cadr lst)) (sorted? (cdr lst)))))
    
(define/contract (sort-descending lst)
  (-> list? sorted?)
  (sort lst (lambda (x y) (> x y))))

;; Next Line returns '(99 45 6 5 3 2 2 1 0 -1)
(sort-descending '(1 99 3 2 45 6 -1 5 0 2))