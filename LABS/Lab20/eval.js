// Assume that this string comes from across the network
// representing employee records.
var jsonStr =
    "[{name: 'Philip J. Fry', age: 1000, job: 'delivery boy'}," +
    " {name: (function(){console.log('***All glory to the Hypnotoad!***')})() }," +
    " {name: 'Bender Rodriguez', age: 42, job: 'bending unit'}]";

var employeeRecords = eval(jsonStr);
for (var i in employeeRecords) {
  var emp = employeeRecords[i];
  console.log(emp.name);
}

/*
$ node eval.js
***All glory to the Hypnotoad!***
Philip J. Fry
undefined
Bender Rodriguez
*/

