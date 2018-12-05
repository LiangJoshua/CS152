class Employee:
    def __init__(self, name, salary, bonus):
        self.name = name
        self.salary = salary
        self.bonus = bonus

    def get_wages(self):
        return self.salary + self.bonus

class Manager(Employee):
    def __init__(self, name, salary, bonus, subordinates):
        Employee.__init__(self, name, salary, bonus)
        self.subordinates = subordinates

    def get_department_wages(self):
        wages = self.get_wages()
        for emp in self.subordinates:
            wages += emp.get_wages()
        return wages

alice = Employee("Alice", 125000, 200)
dilbert = Employee("Dilbert", 100000, 2000)
wally = Employee("Wally", 85000, 0)

phb = Manager("Pointy-haired boss", 136000, 100000, [alice,dilbert,wally])

print("Alice makes " + `alice.get_wages()`)
print("The boss makes " + `phb.get_wages()`)
print("The whole department makes " + `phb.get_department_wages()`)

