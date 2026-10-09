
package OOP_and_Polymorphism.assignment_problems;

class SettlementMember {
    private static int counter = 2000;

    final String membershipNumber;
    String memberId;
    int monthlyFee;
    int feesPaid = 0;
    String paymentMode = "Not specified";

    SettlementMember(int fee) {
        counter++;
        membershipNumber = "GYM-" + counter;
        monthlyFee = fee;
    }

    void payFee(int amount) {
        feesPaid += amount;
    }

    void payFee(int amount, String mode) {
        payFee(amount);
        paymentMode = mode;
    }

    int getFeesPaid() {
        return feesPaid;
    }

    static int getMembersEnrolled() {
        return counter - 2000;
    }

    static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && code.charAt(3) >= 'A'
                && code.charAt(3) <= 'Z';
    }
}

class SettlementGroupMember extends SettlementMember {
    String className;

    SettlementGroupMember(int fee, String name) {
        super(fee);
        className = name;
    }
}

public class WeeklyCheckInSettlement {

    static String processWeeklyCheckIn(SettlementMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (SettlementMember member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof SettlementGroupMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {
        SettlementMember m1 = new SettlementMember(1000);

        System.out.println(m1.membershipNumber);
        System.out.println(SettlementMember.getMembersEnrolled());

        System.out.println(
                SettlementMember.isValidReferralCode("G45B"));
        System.out.println(
                SettlementMember.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid());

        SettlementMember[] members = {
                new SettlementGroupMember(1500, "Zumba"),
                null,
                new SettlementMember(1000)
        };

        System.out.println(processWeeklyCheckIn(members));
    }
}