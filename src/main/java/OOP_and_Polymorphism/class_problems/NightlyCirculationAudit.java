package OOP_and_Polymorphism.class_problems;


class AuditLibraryMemberQ5 {
    private static int counter = 100;
    final String memberNumber;
    int booksBorrowed = 0;
    String genre = "";

    AuditLibraryMemberQ5(int limit) {
        counter++;
        memberNumber = "LIB-" + counter;
    }

    void borrowBook() {
        booksBorrowed++;
    }

    void borrowBook(String genre) {
        borrowBook();
        this.genre = genre;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    static int getMembersEnrolled() {
        return counter - 100;
    }

    static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && code.charAt(3) >= 'A'
                && code.charAt(3) <= 'Z';
    }
}

class AuditFacultyMemberQ5 extends AuditLibraryMemberQ5 {
    String department;

    AuditFacultyMemberQ5(int limit, String department) {
        super(limit);
        this.department = department;
    }
}

public class NightlyCirculationAudit {
    static String processNightlyAudit(AuditLibraryMemberQ5[] members) {
        int processed = 0, skipped = 0, faculty = 0, regular = 0;

        for (AuditLibraryMemberQ5 member : members) {
            if (member == null) {
                skipped++;
                continue;
            }

            processed++;

            if (member instanceof AuditFacultyMemberQ5)
                faculty++;
            else
                regular++;
        }

        return processed + " processed | " + skipped
                + " null skipped | " + faculty
                + " faculty | " + regular + " regular";
    }

    public static void main(String[] args) {
        AuditLibraryMemberQ5 member = new AuditLibraryMemberQ5(3);

        System.out.println(member.memberNumber);
        System.out.println(AuditLibraryMemberQ5.getMembersEnrolled());

        System.out.println(
                AuditLibraryMemberQ5.isValidRenewalCode("R12A"));

        member.borrowBook();
        member.borrowBook("Fiction");
        System.out.println(member.getBooksBorrowed());

        AuditLibraryMemberQ5[] members = {
                new AuditFacultyMemberQ5(5, "Physics"),
                null,
                new AuditLibraryMemberQ5(3)
        };

        System.out.println(processNightlyAudit(members));
    }
}