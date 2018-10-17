class Rabbit {
	name: string;
	constructor(name: string){
		this.name = name;
	}
}
var name: string = "Monty";
var r = new Rabbit("Python");

console.log(r.name);  // ERROR!!!
console.log(name);    // Prints "Python"
