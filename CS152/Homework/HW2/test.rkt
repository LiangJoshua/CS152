#lang racket

(require "interp.rkt")


(define empty-env (hash))

;; Simple test cases
(evaluate (sp-val 3) empty-env)
(evaluate (sp-binop + (sp-val 3) (sp-val 4)) empty-env)
(evaluate (sp-if (sp-val #t) (sp-val 1) (sp-val 0)) empty-env)
(evaluate (sp-if (sp-val #f) (sp-val 5) (sp-val 6)) empty-env)
;(evaluate (sp-if (sp-val 0) (sp-val 1) (sp-val 0)) empty-env) ;; causes an error
(evaluate (sp-while (sp-val #f) (sp-if (sp-val 0) (sp-val 1) (sp-val 0))) empty-env)
;(evaluate (sp-while (sp-val #t) (sp-if (sp-val 0) (sp-val 1) (sp-val 0))) empty-env) ;; causes an error
(evaluate (sp-var "x") (hash "x" 42))
(evaluate (sp-assign "y" (sp-val 18)) (hash "x" 42))
(evaluate (sp-seq (sp-assign "x" (sp-val 18)) (sp-var "x")) empty-env)

;; x := 0;
;; y := 10;
;; while (x<y)
;;   x := x + 1
(evaluate (sp-seq (sp-assign "x" (sp-val 0))
          (sp-seq (sp-assign "y" (sp-val 10))
          (sp-while (sp-binop < (sp-var "x") (sp-var "y"))
                    (sp-assign "x" (sp-binop + (sp-var "x") (sp-val 1))))
          ))
          empty-env)