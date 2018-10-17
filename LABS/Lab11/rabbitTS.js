var Rabbit = /** @class */ (function () {
    function Rabbit(name) {
        this.name = name;
    }
    return Rabbit;
}());
var r = new Rabbit("Python");
var nam = "Monty";
console.log(r.name); // ERROR!!!
console.log(name); // Prints "Python"
