package abstraction_and_interface.assignment_problems;


class MembershipGymMember {
    String memberId;
    int fee;
    int sessions = 0;

    MembershipGymMember(String id, int fee) {
        this.memberId = id;
        this.fee = fee;
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

class MembershipPremiumMember extends MembershipGymMember {
    String trainer;

    MembershipPremiumMember(String id, int fee, String trainer) {
        super(id, fee);
        this.trainer = trainer;
    }

    @Override
    void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainer
                + " | Sessions: " + sessions);
    }
}

class EliteMember extends MembershipPremiumMember {
    String locker;

    EliteMember(String id, int fee, String trainer, String locker) {
        super(id, fee, trainer);
        this.locker = locker;
    }

    @Override
    void displayInfo() {
        System.out.println("Elite Member | Trainer: " + trainer
                + " | Locker: " + locker + " | Sessions: " + sessions);
    }
}

class GroupClassMember extends MembershipGymMember {
    String className;

    GroupClassMember(String id, int fee, String className) {
        super(id, fee);
        this.className = className;
    }

    @Override
    void displayInfo() {
        System.out.println("Group Class Member | Class: " + className
                + " | Sessions: " + sessions);
    }
}

public class MembershipTest {
    static String classifyGeneration(MembershipGymMember member) {
        if (member instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";
        if (member instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";
        return "Standard or Premium Member";
    }

    static int getTotalSessionsAttended(MembershipGymMember[] members) {
        int total = 0;

        for (MembershipGymMember member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }

    public static void main(String[] args) {
        MembershipGymMember m1 = new MembershipGymMember("MEM1", 1000);
        MembershipPremiumMember m2 = new MembershipPremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember m3 = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember m4 =
                new GroupClassMember("MEM4", 1500, "Zumba");

        m1.displayInfo();
        m2.displayInfo();
        m3.displayInfo();
        m4.displayInfo();

        System.out.println(classifyGeneration(m3));
        System.out.println(classifyGeneration(m4));

        m2.attendSession();
        m2.attendSession();
        m3.attendSession();
        m4.attendSession();

        System.out.println(getTotalSessionsAttended(
                new MembershipGymMember[]{m2, m3, m4}));
    }
}