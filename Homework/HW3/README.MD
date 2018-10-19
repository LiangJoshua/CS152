# HW 3: JS programming contracts

In this homework, you will write a module for adding programming contracts
to JavaScript functions. For more details on programming contracts,
see http://se.ethz.ch/~meyer/publications/computer/contract.pdf.

Starter code is available on the course website.

==================================================
# Part 0 (no points) -- Set up your node environment
==================================================

From the command line, type the following commands (assuming Unix/OSX/Windows+Cygwin):

$ mkdir contracts

$ cd contracts

$ npm init

Use the defaults, except for "main" (specify contracts.js), "test" (specify mocha),
and "author" (specify your name). If you make a mistake, you can edit package.json
to correct.

Also, use npm to install different modules that you will need:

$ npm install mocha


========================================
Part 1 (5 pts) -- Handle basic contracts
========================================

A contract is a JavaScript function that takes in one argument
and returns true if the argument meets certain conditions;
otherwise it returns false. (The functions may have an optional
"expected" property for more informative error messages).

Two contracts are implemented for you:

any: Accepts any argument.
isNumber: Returns true if the argument is a number.

Implement the following contracts:

isBoolean
isDefined: Returns true if the argument is neither null or undefined.
isString
isNegative
isPositive


A contract combinator takes 1 or more contracts and returns a new contract.
The 'and' combinator is done for you; it takes a variable number of contracts
and returns true only if all of the original contracts return true.

Implement the following contract combinators:

not: Takes a single contract; returns a contract that returns true
only if the original contract returns false.
or: Takes a variable number of contracts; returns true if any of
the original contracts return true.


To test your code, run `npm test`. Before you move on to the next part, all tests should pass.

I recommend adding additional unit tests as you progress. It is an excellent way to verify
that your code does what you expect. It also helps you to catch when you accidentally break
your code. Whenever you think about adding some lines of code to test, consider putting this
code in a unit test.

When you are satisfied that this piece is working correctly, make this library available
on your system. On the command line, change to the 'contracts' directory and type `npm link`.
See https://docs.npmjs.com/cli/link for more details on this command.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
