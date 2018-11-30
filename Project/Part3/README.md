For this submission, you have two choices.

If you did poorly on either of the previous project submissions, you may redo the old assignment for a new grade.  Submit a note here letting me know which assignment to regrade, and resubmit the old project submission to the original submission page.  (Of course, you will get a 0 for part 3).

Alternately, you can write a visitor to walk the parse tree, build up an AST (using the Expression class you did in part 2), and run it.

PART 3 -- Write a visitor
----------------------------
Use the same directory structure as in part 2 of the assignment.  Download ExpressionBuilderVisitor.java and Interpreter.java and put them in src/edu/sjsu/fwjs/.

ExpressionBuilderVisitor.java constructs an AST of Expressions (from Expression.java).  Complete this code.  Once you have it working, you can use Interpreter.java (replacing the previous Interpreter.java) to interpret the scripts in the fwjsScripts directory.

The new version of the Makefile contains a 'run' target that will execute all of the fwjs scripts that you have been provided.

When you have completed this assignment, submit a zip file with the following directory structure:

src/: Contains your **hand-written** Java code.  YOU WILL LOSE POINTS IF YOU INCLUDE YOUR ANTLR-GENERATED CODE HERE.
FeatherweightJavaScript.g4: Your ANTLR grammar.
