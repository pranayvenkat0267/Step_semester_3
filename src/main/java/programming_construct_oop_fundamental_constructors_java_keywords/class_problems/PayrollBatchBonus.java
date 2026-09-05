package programming_construct_oop_fundamental_constructors_java_keywords.class_problems;

public class PayrollBatchBonus {

    static class Employee {
        String empId;
        double salary;

        public Employee(String empId, double salary) {
            this.empId = empId;
            this.salary = salary;
        }

        public void raiseSalary(double salary) {
            this.salary += salary;
        }

        public void printSalary() {
            System.out.println(empId +
                    " | Final Salary: Rs " + salary);
        }
    }

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("E-101", 40000),
                new Employee("E-102", 55000),
                new Employee("E-103", 62000),
                new Employee("E-104", 48000)
        };

        double salary = 5000;

        for (Employee employee : employees) {
            employee.raiseSalary(salary);
            employee.printSalary();
        }
    }
}
