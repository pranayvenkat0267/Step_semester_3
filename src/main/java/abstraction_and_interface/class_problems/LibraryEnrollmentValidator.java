package abstraction_and_interface.class_problems;

class PracticeLibraryMemberQ1 {
    String memberId;
    int borrowLimit;
    int booksBorrowed = 0;

    PracticeLibraryMemberQ1(String id, int limit) {
        if (id == null || id.trim().length() < 4)
            throw new IllegalArgumentException();

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
}

class PracticeStudentMemberQ1 extends PracticeLibraryMemberQ1 {
    String course;

    PracticeStudentMemberQ1(String id, int limit, String course) {
        super(id, limit);
        this.course = course;
    }
}

public class LibraryEnrollmentValidator {
    static String enrollBatch(String[] ids, int limit) {
        int enrolled = 0, rejected = 0;

        for (String id : ids) {
            try {
                new PracticeLibraryMemberQ1(id, limit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(enrollBatch(ids, 3));
    }
}