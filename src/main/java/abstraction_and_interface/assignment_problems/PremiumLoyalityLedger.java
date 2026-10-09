
package abstraction_and_interface.assignment_problems;

import java.util.Arrays;

class LateFeeGymMember {
    private String memberId;
    private int monthlyFee;
    private int[] lateFeeHistory = new int[10];
    private int count = 0;

    LateFeeGymMember(String id, int fee) {
        memberId = id;
        monthlyFee = fee;
    }

    protected void chargeLateFee(int amount) {
        if (count < lateFeeHistory.length && amount > 0) {
            lateFeeHistory[count] = amount;
            count++;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, count);
    }

    public int getTotalLateFees() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            total += lateFeeHistory[i];
        }

        return total;
    }
}

class LateFeePremiumMember extends LateFeeGymMember {

    LateFeePremiumMember(String id, int fee, String trainer) {
        super(id, fee);
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class PremiumLoyalityLedger {
    public static void main(String[] args) {

        LateFeePremiumMember p =
                new LateFeePremiumMember("MEM5", 2000, "Coach Riya");

        p.chargeLateFee(200);

        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999;

        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}