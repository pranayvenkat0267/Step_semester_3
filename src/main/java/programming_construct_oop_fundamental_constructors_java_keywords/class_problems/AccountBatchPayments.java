package programming_construct_oop_fundamental_constructors_java_keywords.class_problems;

public class AccountBatchPayments {

    static class FeeAccount {

        public void processPayment(double amount) {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    static class HostelFeeAccount extends FeeAccount {

        @Override
        public void processPayment(double amount) {
            System.out.println("Paid in two installments (hostel account)");
        }

        public void payWithProcessingFee(double amount) {
            double total = amount + amount * 0.02;
            System.out.println("Charged (card, incl. fee): Rs " + total);
        }
    }

    public static void processPayment(FeeAccount account,
                                      double amount) {

        if (account instanceof HostelFeeAccount) {

            HostelFeeAccount hostelAccount =
                    (HostelFeeAccount) account;

            hostelAccount.payWithProcessingFee(amount);

        } else {
            account.processPayment(amount);
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };

        double amount = 60000;

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (FeeAccount account : accounts) {

            processPayment(account, amount);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel accounts processed: "
                + hostelCount);

        System.out.println("Day-scholar accounts processed: "
                + dayScholarCount);
    }
}
