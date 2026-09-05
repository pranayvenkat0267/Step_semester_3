package OOPFundamental.assignment_problems;

class EmployeeStatic {

    // Instance fields
    String empName;
    double salary;

    // Static field shared by every employee
    static String companyName =
            "Bright Horizon Technologies";

    // Static counter
    static int employeeCount = 0;

    public EmployeeStatic(String empName,
                          double salary) {

        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println(
                "Employees on record: "
                        + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeStatic e1 =
                new EmployeeStatic(
                        "Ravi", 50000);

        EmployeeStatic e2 =
                new EmployeeStatic(
                        "Priya", 60000);

        EmployeeStatic e3 =
                new EmployeeStatic(
                        "Arjun", 55000);

        // Call static method through class name
        EmployeeStatic.printCompanyInfo();
    }
}
