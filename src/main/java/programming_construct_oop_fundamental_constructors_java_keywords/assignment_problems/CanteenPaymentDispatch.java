package programming_construct_oop_fundamental_constructors_java_keywords.assignment_problems;

public class CanteenPaymentDispatch {

    static class Payment {

        public void pay(double amount) {
            System.out.println("Paid (cash): Rs " + amount);
        }
    }

    static class CardPayment extends Payment {

        public void payWithProcessingFee(double amount) {

            double total = amount + amount * 0.02;

            System.out.println(
                    "Charged (card, incl. fee): Rs " + total);
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid (cash): Rs " + amount);
        }
    }

    public static double totalCollected = 0;

    public static void processTransaction(
            Payment payment, double amount) {

        if (payment instanceof CardPayment) {

            CardPayment cardPayment =
                    (CardPayment) payment;

            cardPayment.payWithProcessingFee(amount);

            totalCollected += amount + amount * 0.02;

        } else {

            payment.pay(amount);

            totalCollected += amount;
        }
    }

    public static void main(String[] args) {

        Payment[] payments = {
                new CardPayment(),
                new Payment(),
                new CardPayment(),
                new CardPayment(),
                new Payment()
        };

        double[] amounts = {
                100, 50, 200, 75, 120
        };

        for (int i = 0; i < payments.length; i++) {

            processTransaction(
                    payments[i],
                    amounts[i]);
        }

        System.out.println(
                "Total Collected: Rs " + totalCollected);
    }
}