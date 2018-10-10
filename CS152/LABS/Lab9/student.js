function student(firstName, lastName, studentID, display) {
    this.firstName = firstName
    this.lastName = lastName
    this.studentID = studentID
    this.display = function(){
        console.log(firstName + ' ' + lastName + studentID)
    }
}

newStudents = []
for(var i = 0; i < 10; i++) {
    newStudents[i] = new student("First", "Last", i)
}
newStudents[0].graduated = true;

newStudents[10] = {
    "firstName": "Joshua",
    "lastName": "Liang",
    "studentID": 10,
    __proto__: student
}

console.log(newStudents);