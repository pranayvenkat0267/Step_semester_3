package OOPFundamental.assignment_problems;

class Employee {

String empId;
String empName;
double salary;
boolean isIntern;

// Constructor for permanent employee
public Employee(String empId,
                String empName,
                double salary) {

    this.empId = empId;
    this.empName = empName;
    this.salary = salary;
    this.isIntern = false;
}

// Constructor for intern
// Uses this() constructor chaining
public Employee(String empId,
                String empName) {

    this(empId, empName, 0);

    this.isIntern = true;
}

public void printProfile() {

    System.out.println(
            empId + " | " +
                    empName + " | Rs " +
                    salary + " | Intern: " +
                    isIntern);
}

public static void main(String[] args) {

    Employee permanent =
            new Employee(
                    "E-101",
                    "Divya",
                    65000);

    Employee intern =
            new Employee(
                    "E-102",
                    "Arjun");

    permanent.printProfile();
    intern.printProfile();
}
}