

package OOP_and_Polymorphism.assignment_problems;

class AttendanceMember {
    String memberId;
    int sessions = 0;

    AttendanceMember(String id) {
        memberId = id;
    }

    void attendSession() {
        sessions++;
    }

    int getSessionsAttended() {
        return sessions;
    }

    void displayInfo() {
        System.out.print("Standard | Sessions: " + sessions);
    }
}

class AttendancePremiumMember extends AttendanceMember {
    String trainerName;

    AttendancePremiumMember(String id, String trainer) {
        super(id);
        trainerName = trainer;
    }

    @Override
    void displayInfo() {
        System.out.print("Premium | Sessions: " + sessions);
    }

    String getTrainerName() {
        return trainerName;
    }
}

public class MonthlyAttendanceAnnouncer {

    static String batchPrint(AttendanceMember[] members) {
        StringBuilder result = new StringBuilder();

        for (AttendanceMember member : members) {
            result.append("Member: ");
            member.displayInfo();

            // Build the announcement using StringBuilder.
            StringBuilder details = new StringBuilder();
            details.append(member.memberId)
                    .append(" | Sessions: ")
                    .append(member.getSessionsAttended());

            if (member instanceof AttendancePremiumMember) {
                AttendancePremiumMember premium =
                        (AttendancePremiumMember) member;

                details.append(" | Trainer: ")
                        .append(premium.getTrainerName());
            }

            result.append(details).append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AttendanceMember[] members = {
                new AttendanceMember("MEM6"),
                new AttendancePremiumMember("MEM7", "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}