"use strict";
var name = "Monty";
function Rabbit(name) {
  this.name = name;
}
var r = new Rabbit("Python");

console.log(r.name);  //Python
console.log(name);    //Monty
