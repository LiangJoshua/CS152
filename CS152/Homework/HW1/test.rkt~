#lang racket

(require "big-num.rkt")

;; 999 + 456
(big-add '(999) '(456))
;; 1,999 + 1,456
(big-add '(999 1) '(456 1))
;; 681,234,999 + 456
(big-add '(999 234 681) '(456))
;; 456 + 681,234,999
(big-add '(456) '(999 234 681))
;; 681,000,999 + 456
(big-add '(999 0 681) '(456))

;; 999 - 456
(big-subtract '(999) '(456))
;; 1,000 - 1
(big-subtract '(0 1) '(1))
;; 9,643,291 - 8,329
(big-subtract '(291 643 9) '(329 8))
;; 999,999 - 999,998
(big-subtract '(999 999) '(998 999))
;; 999,999 - 999,999
(big-subtract '(999 999) '(999 999))

;;;;;;;; Error cases commented out
;; 9 - 10
; (big-subtract '(9) '(10))
;; 987 - 1000
; (big-subtract '(987) '(0 1))

;; 3 * 4
(big-multiply '(3) '(4))

;; 2^8
(big-power-of '(2) '(8))

;; Java can't do this
(pretty-print (big-multiply '(999 999 999 999 999 999 999) '(2)))

(pretty-print '(2 2 1))

