package OOPFundamental.class_problems;


class Student {

    // Instance fields
    String name;
    double attendance;

    // Static fields shared by all objects
    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {

        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Priya", 95);

        // Static method called through class name
        Student.printCollegeInfo();
    }
}