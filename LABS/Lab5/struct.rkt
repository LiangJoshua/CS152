#lang racket

(struct employee (fname lname salary))
(struct manager (fname lname salary bonus))

(define (calc-wages emp)
  (match emp
    [(struct employee (first last sal)) sal]
    [(struct manager (first last sal extra)) (+ sal extra)]))

(let ([dilbert (employee "Dilbert" "Adams" 80000)]
      [alice   (employee "Alice" "Rage" 95000)]
      [phb     (manager "Boss" "Pointy-Haired" 105000 200000)])
  (displayln (calc-wages dilbert))
  (displayln (calc-wages alice))
  (displayln (calc-wages phb)))