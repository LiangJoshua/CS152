# HW 3: JS programming contracts

In this homework, you will write a module for adding programming contracts
to JavaScript functions. For more details on programming contracts,
see http://se.ethz.ch/~meyer/publications/computer/contract.pdf.

Starter code is available on the course website.

==================================================
### Part 0 (no points) -- Set up your node environment
==================================================

From the command line, type the following commands (assuming Unix/OSX/Windows+Cygwin):

$ mkdir contracts\
$ cd contracts\
$ npm init\

Use the defaults, except for "main" (specify contracts.js), "test" (specify mocha),
and "author" (specify your name). If you make a mistake, you can edit package.json
to correct.

Also, use npm to install different modules that you will need:

$ npm install mocha


========================================
### Part 1 (5 pts) -- Handle basic contracts
========================================

A contract is a JavaScript function that takes in one argument
and returns true if the argument meets certain conditions;
otherwise it returns false. (The functions may have an optional
"expected" property for more informative error messages).

Two contracts are implemented for you:

any: Accepts any argument.
isNumber: Returns true if the argument is a number.

Implement the following contracts:

isBoolean\
isDefined: Returns true if the argument is neither null or undefined.\
isString\
isNegative\
isPositive\


A contract combinator takes 1 or more contracts and returns a new contract.
The 'and' combinator is done for you; it takes a variable number of contracts
and returns true only if all of the original contracts return true.

Implement the following contract combinators:

not: Takes a single contract; returns a contract that returns true\
only if the original contract returns false.\
or: Takes a variable number of contracts; returns true if any of\
the original contracts return true.\


To test your code, run `npm test`. Before you move on to the next part, all tests should pass.

I recommend adding additional unit tests as you progress. It is an excellent way to verify
that your code does what you expect. It also helps you to catch when you accidentally break
your code. Whenever you think about adding some lines of code to test, consider putting this
code in a unit test.

When you are satisfied that this piece is working correctly, make this library available
on your system. On the command line, change to the 'contracts' directory and type `npm link`.
See https://docs.npmjs.com/cli/link for more details on this command.

=====================================================
### Part 2 (10 pts) -- First attempt at contract function
=====================================================

Programming contracts are focused on ensuring that the inputs to a function are correct,
and that the return value is correct. Most importantly, when something does go wrong,
the contract library should be able to identify who is at fault -- the library writer,
or the user of the library.

Implement the contract function in contracts.js. It takes in a list of pre-conditions,
a post-condition, and the function itself. If any of the pre-conditions are not met,
throw an exception blaming the caller. If the post-condition is not met, throw an
exception blaming the library. (The pre-conditions and post-condition are specified
using the contracts that you defined in part 1.)

Write some unit tests to verify that your function seems correct. Once you are satisfied,
create a new 'example' project to test out your code. If you start in the contracts directory:

$ cd ..\
$ mkdir example\
$ npm init\
$ npm link contracts\

All defaults are OK. Copy in the sample example programs to this directory.

The example1.js program shows some examples to consider. From the example directory,
run `node example1.js` to test. The output of this program should exactly match example1.output.

=========================================================
### Part 3 (5 pts) -- More advanced contracts
=========================================================

JavaScript Proxies can simplify asserting properties about the parent object.
(You are not required to use them for this portion, but you might find it easier).

The example2.js file contains some contracts involving objects.
To handle this case, you will need to use the handler.apply
and the handler.construct traps. Your output should exactly
match example2.output.

In example3.js, we see an alternate approach using objects.
There is a custom contract that uses the 'this' keyword to refer to
the object containing the method. Again, your output should
match example2.output exactly.

================================================================
### Part 4 -- Submit your code
================================================================

Upload your contracts.js file to Canvas.

Do not submit any other files or you will lose points.
