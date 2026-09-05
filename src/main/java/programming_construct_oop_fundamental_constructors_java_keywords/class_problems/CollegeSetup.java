package programming_construct_oop_fundamental_constructors_java_keywords.class_problems;

public class CollegeSetup {

    static class Student {

        static String collegeName;
        static String academicYear;

        String name;

        static {
            collegeName = "SRM Institute of Science and Technology";
            academicYear = "2026";
            System.out.println("College info loaded");
        }

        Student(String name) {
            this.name = name;
        }

        public void printConfirmation() {
            System.out.println("Student record created: " + name);
        }
    }

    public static void main(String[] args) {

        String[] names = {
                "Ravi",
                "Meera",
                "Karthik",
                "Divya",
                "Anitha"
        };

        for (String name : names) {
            Student student = new Student(name);
            student.printConfirmation();
        }
    }
}