#lang racket

(define-syntax-rule (swap x y)
  (let ([tmp x])
    (set! x y)
    (set! y tmp)))
    
(let ([a 7][b 3])
  (swap a b)
  a)

(let ([tmp 7][b 3])
  (swap tmp b)
  tmp)

(define-syntax-rule (ite cond thn els)
  (if cond thn els))

(define x 3)
(ite (= x 3) (displayln "x is 3") (displayln "x is NOT 3"))

(define-syntax rotate
  (syntax-rules ()
    [(rotate a b) (swap a b)]
    [(rotate a b c)
     (begin
       (swap a b)
       (swap b c))]))
  
(let ([red 1] [green 2] [blue 3])
  (rotate red green)
  (displayln red)
  (displayln green)
  )

(let ([red 1] [green 2] [blue 3])
  (rotate red green blue)
  (displayln red)
  (displayln green)
  (displayln blue)
  )

(define-syntax rotate-all
  (syntax-rules ()
    [(rotate-all a) (void)]
    [(rotate-all a b c ...)
     (begin
       (swap a b)
       (rotate-all b c ...))]))

(let ([a 1] [b 2] [c 3] [d 4] [e 5])
  (rotate-all a b c d e)
  (displayln a)
  (displayln b)
  (displayln c)
  (displayln d)
  (displayln e))
  
(newline)
