class Rabbit {
	name: string;
	constructor(name: string){
		this.name = name;
	}
}

var r = new Rabbit("Python");
var name = "Monty";
console.log(r.name);  //Python
console.log(name);    //Monty
