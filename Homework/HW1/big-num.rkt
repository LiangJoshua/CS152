#lang racket

;; The big-num data structure is essentially a list of 3 digit numbers.

;; Exporting methods
(provide big-add big-subtract big-multiply big-power-of pretty-print number->bignum string->bignum)

(define MAX_BLOCK 1000)

;; Addition of two big-nums
(define (big-add x y)
  (big-add1 x y 0)
  )

(define (big-add1 x y co)
  (cond
    ;; If both lists are empty, the return value is either 0 or the caryover value.
    [(and (= 0 (length x)) (= 0 (length y)))
     (if (= co 0) '() (list co))]
    [(= 0 (length x))  (big-add1 (list co) y 0)]
    [(= 0 (length y))  (big-add1 x (list co) 0)]
    [else
     (if (< 999 (+ (car x) (car y) co))
         (append
          (list (- (+ (car x) (car y) co) 1000))
          (big-add1 (cdr x) (cdr y) 1))
        
         (append
          (list (+ (car x) (car y) co))
          (big-add1 (cdr x) (cdr y) 0)))
    
     ]
    ))

;; Subtraction of two big-nums
(define (big-subtract x y)
  (let ([lst (big-subtract1 x y 0)])
    (reverse (strip-leading-zeroes (reverse lst)))
    ))

(define (strip-leading-zeroes x)
  (cond
    [(= 0 (length x)) '(0)]
    [(= 0 (car x)) (strip-leading-zeroes (cdr x))]
    [else x]
    ))

;; NOTE: there are no negative numbers with this implementation,
;; so 3 - 4 should throw an error.
(define (big-subtract1 x y borrow)
  (cond
    [(and (= 0 (length x)) (= 0 (length y))) '()]
    [(and (= (length x) (length y)) (< (last x) (last y))) (string "error, no negative numbers")]
    [(= 0 (length y))  (list (- (car x) borrow))]
    [(< (length x) (length y)) (string "error, no negative numbers")]
    [else (if (< (car x) (car y))
              (append
               (list (- (+ 1000 (car x)) (car y) borrow))
               (big-subtract1 (cdr x) (cdr y) 1))
              (append
               (list (- (car x) (car y) borrow))
               (big-subtract1 (cdr x) (cdr y) 0)))]))


;; Returns true if two big-nums are equal
(define (big-eq x y)
  (cond
    [(and (= 0 (length x)) (= 0 (length y))) #t]
    [(= (length x) (length y))
     (if (= (car x) (car y))
         (big-eq (cdr x) (cdr y))
         #f)
     ]
    )
  )
  

;; Decrements a big-num
(define (big-dec x)
  (big-subtract x '(1))
  )

;; Multiplies two big-nums
(define (big-multiply x y)
  (if (= 1 (car y)) x
      (big-add x (big-multiply x (big-dec y)))))

;; Raise x to the power of y
(define (big-power-of x y)
  (if (= 1 (car y)) x
      (big-multiply x (big-power-of x (big-dec y)))))

;; Dispaly a big-num in an easy to read format
(define (pretty-print x)
  (let ([lst (reverse x)])
    (string-append
     (number->string (car lst))
     (pretty-print1 (cdr lst))
     )))

(define (pretty-print1 x)
  (cond
    [(= 0 (length x))  ""]
    [else
     (string-append (pretty-print-block (car x)) (pretty-print1 (cdr x)))]
    ))

(define (pretty-print-block x)
  (string-append
   ","
   (cond
     [(< x 10) "00"]
     [(< x 100) "0"]
     [else ""])
   (number->string x)))

;; Convert a number to a bignum
(define (number->bignum n)
  (cond
    [(< n MAX_BLOCK) (list n)]
    [else
     (let ([block (modulo n MAX_BLOCK)]
           [rest (floor (/ n MAX_BLOCK))])
       (cons block (number->bignum rest)))]))

;; Convert a string to a bignum
(define (string->bignum s)
  (let ([n (string->number s)])
    (number->bignum n)))