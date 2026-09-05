package programming_construct_oop_fundamental_constructors_java_keywords.class_problems;

public class LateFees {

    static class Account {
        String regNo;
        double totalFee;

        Account(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
        }

        public final double calculateLateFee(int daysLate) {
            return daysLate * 2000;
        }

        public final void printSummary(int daysLate) {
            if (daysLate <= 0) {
                System.out.println(regNo + " - On time, no late fee");
                return;
            }

            double lateFee = calculateLateFee(daysLate);

            System.out.println(regNo +
                    " | Total Fee: Rs " + totalFee +
                    " | Late Fee: Rs " + lateFee);
        }
    }

    public static void main(String[] args) {

        String[] regNos = {
                "RA001", "RA002", "RA003", "RA004"
        };

        double[] totalFees = {
                20000, 15000, 18000, 22000
        };

        int[] daysLate = {
                10, 0, -2, 5
        };

        for (int i = 0; i < regNos.length; i++) {

            Account account =
                    new Account(regNos[i], totalFees[i]);

            account.printSummary(daysLate[i]);
        }
    }
}