package OOP_and_Polymorphism.class_problems;

class ReportLibraryMemberQ4 {
    String memberId;
    int booksBorrowed = 0;

    ReportLibraryMemberQ4(String id) {
        memberId = id;
    }

    void borrowBook() {
        booksBorrowed++;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}

class ReportStudentMemberQ4 extends ReportLibraryMemberQ4 {
    String course;

    ReportStudentMemberQ4(String id, String course) {
        super(id);
        this.course = course;
    }

    @Override
    String displayInfo() {
        return "Student | Books: " + booksBorrowed
                + " [Course via downcast: " + course + "]";
    }
}

public class WeeklyCirculationReport {
    static String batchPrint(ReportLibraryMemberQ4[] members) {
        StringBuilder report = new StringBuilder();

        for (ReportLibraryMemberQ4 member : members) {
            report.append(member.displayInfo()).append(" | ");

            if (member instanceof ReportStudentMemberQ4) {
                ReportStudentMemberQ4 student =
                        (ReportStudentMemberQ4) member;

                // The subclass information is available safely here.
                student.course.length();
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {
        ReportLibraryMemberQ4[] members = {
                new ReportLibraryMemberQ4("LB5"),
                new ReportStudentMemberQ4("STU6", "ECE")
        };

        members[0].borrowBook();
        members[1].borrowBook();

        System.out.println(batchPrint(members));
    }
}