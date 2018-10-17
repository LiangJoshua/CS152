class Rabbit {
	name: string;
	constructor(name: string){
		this.name = name;
	}
}

var r = new Rabbit("Python");
var nam = "Monty";
console.log(r.name);  //Python
console.log(name);    // Prints "Python"
