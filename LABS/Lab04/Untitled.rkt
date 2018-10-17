#lang racket
(provide sumofsquares1 sumofsquares2 join-strings make-html-tags)

;; Given a list of numbers, produce the sum of their squares. 
;; Use foldr, not recursion.
(define (sumofsquares1 lst)
  (foldr
   (lambda (x y) (+ (sqr x) y)) 
  0 
   lst)
)

;; Repeat with foldl
(define (sumofsquares2 lst)
  (foldl
   (lambda (x y) (+ (sqr x) y)) 
  0 
   lst)
  )

;; Using foldl, combine a list of strings into a single string,
;; separated by the specified separator.  Separators should only
;; appear between words
(define (join-strings list-of-strings separator)
  (foldl
   (lambda (x y) 
   (if (equal? y "") (string-append y x)
   (string-append y separator x)))
  ""
   list-of-strings)
)

;; Make matching open and close tags, using the list of tag-names
(define (make-html-tags tag-names)
  (string-append
   (foldl
    ;; YOUR CODE HERE
    tag-names)
   (foldr
    ;; YOUR CODE HERE
    tag-names))
)
      