#lang racket

(require racket/contract)

(struct account (balance))

(provide new-account balance withdraw deposit account)

(define (positiveBal? amt)
  (if (< (balance amt) 0) #f #t))

;; A new, empty account
(define new-account (account 0))

;; Get the current balance
(define/contract (balance acc)
  (-> account? number?)
  (account-balance acc))

;; Withdraw funds from an account
(define/contract (withdraw acc amt)
  (-> account? positive? (and/c account? positiveBal?))
  (account (- (account-balance acc) amt)))

;; Add funds to an account
(define/contract (deposit acc amt)
  (-> account? positive? account?)
  (account (+ (account-balance acc) amt)))
