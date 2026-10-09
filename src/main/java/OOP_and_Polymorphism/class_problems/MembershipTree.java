package OOP_and_Polymorphism.class_problems;

class TreeLibraryMemberQ2 {
    String memberId;
    int borrowLimit;
    int booksBorrowed = 0;

    TreeLibraryMemberQ2(String id, int limit) {
        memberId = id;
        borrowLimit = limit;
    }

    void borrowBook() {
        if (booksBorrowed < borrowLimit)
            booksBorrowed++;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    void displayInfo() {
        System.out.println("General Member | Books Borrowed: "
                + booksBorrowed);
    }
}

class TreeStudentMemberQ2 extends TreeLibraryMemberQ2 {
    String course;

    TreeStudentMemberQ2(String id, int limit, String course) {
        super(id, limit);
        this.course = course;
    }

    @Override
    void displayInfo() {
        System.out.println("Student Member | Course: " + course
                + " | Books Borrowed: " + booksBorrowed);
    }
}

class HonorsStudentQ2 extends TreeStudentMemberQ2 {
    int bonusLimit;

    HonorsStudentQ2(String id, int limit, String course, int bonus) {
        super(id, limit, course);
        bonusLimit = bonus;
    }

    @Override
    void displayInfo() {
        System.out.println("Honors Student Member | Course: " + course
                + " | Bonus Limit: " + bonusLimit
                + " | Books Borrowed: " + booksBorrowed);
    }
}

class FacultyMemberQ2 extends TreeLibraryMemberQ2 {
    String department;

    FacultyMemberQ2(String id, int limit, String department) {
        super(id, limit);
        this.department = department;
    }

    @Override
    void displayInfo() {
        System.out.println("Faculty Member | Department: " + department
                + " | Books Borrowed: " + booksBorrowed);
    }
}

public class MembershipTree {
    static String classifyGeneration(TreeLibraryMemberQ2 member) {
        if (member instanceof HonorsStudentQ2)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof FacultyMemberQ2)
            return "Hierarchical sibling (independent branch)";

        return "General member";
    }

    static int getTotalBooksBorrowed(TreeLibraryMemberQ2[] members) {
        int total = 0;

        for (TreeLibraryMemberQ2 member : members)
            total += member.getBooksBorrowed();

        return total;
    }

    public static void main(String[] args) {
        TreeLibraryMemberQ2 student =
                new TreeStudentMemberQ2("STU2", 3, "CSE");
        TreeLibraryMemberQ2 honors =
                new HonorsStudentQ2("STU3", 3, "ECE", 2);
        TreeLibraryMemberQ2 faculty =
                new FacultyMemberQ2("STU4", 5, "Physics");

        student.borrowBook();
        student.borrowBook();
        honors.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        student.displayInfo();
        honors.displayInfo();
        faculty.displayInfo();

        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        System.out.println(getTotalBooksBorrowed(
                new TreeLibraryMemberQ2[]{student, honors, faculty}));
    }
}