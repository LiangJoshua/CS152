#lang racket
(struct account (balance))
(define new-account (account 0))
(define (balance acc)
(account-balance acc))
(define (deposit acc amt)
(account (+ (account-balance acc) amt)))