var Rabbit = /** @class */ (function () {
    function Rabbit(name) {
        this.name = name;
    }
    return Rabbit;
}());
name: string = "Monty";
var r = new Rabbit("Python");
console.log(r.name); // ERROR!!!
console.log(name); // Prints "Python"
