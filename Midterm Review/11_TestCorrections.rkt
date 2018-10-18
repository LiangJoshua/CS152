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