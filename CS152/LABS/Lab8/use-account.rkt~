#lang racket

(require "account.rkt")

(define my-account new-account)

;; Good examples
(displayln (balance (deposit my-account 40)))
(displayln (balance (withdraw (deposit my-account 40) 25)))

;; Bad examples
(displayln (balance (deposit my-account -40)))
(displayln (balance (withdraw (deposit my-account 40) 95)))
(displayln (balance (deposit my-account "42")))