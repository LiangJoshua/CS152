#lang racket
(provide largest-elem)
(define (largest-elem lst)
  (cond
    [(empty? lst) (error "list is empty")]
    [(empty? (cdr lst)) (car lst)]
    [(< (car lst) (cadr lst)) (largest-elem (cdr lst))]
    (else largest-elem (cons (car lst) (cddr lst)))))
           
                  