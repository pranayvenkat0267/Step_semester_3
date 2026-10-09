package OOP_and_Polymorphism.assignment_problems;

class GymMember {
    String memberId;
    int monthlyFee;
    int sessions;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4
                || monthlyFee <= 0) {
            throw new IllegalArgumentException("Invalid member");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        sessions = 0;
    }

    void attendSession() {
        sessions++;
    }

    int getSessionsAttended() {
        return sessions;
    }

    void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessions);
    }
}

class PremiumMember extends GymMember {
    String trainerName;

    public PremiumMember(String memberId, int monthlyFee,
                         String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo() {
        System.out.println("Premium Member | Trainer: "
                + trainerName + " | Sessions: " + sessions);
    }
}

public class GymMemberTest {
    static String signUpBatch(String[] ids, int fee) {
        int signed = 0, rejected = 0;

        for (String id : ids) {
            try {
                new GymMember(id, fee);
                signed++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signed + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        String[] ids = {"MEM1", "GM1", "MEM2", " ", "MEM3"};

        System.out.println(signUpBatch(ids, 1000));
    }
}