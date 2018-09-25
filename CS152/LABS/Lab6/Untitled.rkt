#lang racket

(define (box x)
  ;; when the second item to cons is not
  ;; a list, we have a pair.
  (cons
   (λ() x)
   (λ(y) (set! x y))))

(define (get-val bx)
  ((car bx)))
(define (set-val! bx new-val)
  ((cdr bx) new-val))


;; An employee object is represented as a list of
;; 3 setter-getter pairs
(define (Employee name position salary)
  (list
    (box name)
    (box position)
    (box salary)))


(define (get-name emp)
  (get-val (car emp)))
(define (set-name emp new-name)
  (set-val! (car emp) new-name))

(define (get-position emp)
 (get-val (cadr emp)))
(define (set-position emp new-pos)
  (set-val! (cadr emp) new-pos))

(define (get-salary emp)
  (get-val (caddr emp)))
(define (set-salary emp new-sal)
  (set-val! (caddr emp) new-sal))

(define prof (Employee "Austin" "Professor" 99999999999999999))

(get-name prof)
(get-position prof)
(get-salary prof)

(set-name prof "Tom the Mighty")
(set-position prof "Master of Time and Space")
(set-salary prof 12345678)

(get-name prof)
(get-position prof)
(get-salary prof)
