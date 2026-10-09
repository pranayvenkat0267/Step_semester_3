package OOP_and_Polymorphism.class_problems;

import java.util.Arrays;

class FineLibraryMemberQ3 {
    private int[] fineHistory = new int[10];
    private int count = 0;

    protected void chargeFine(int amount) {
        if (count < fineHistory.length && amount > 0) {
            fineHistory[count] = amount;
            count++;
        }
    }

    int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, count);
    }

    int getTotalFine() {
        int total = 0;

        for (int i = 0; i < count; i++)
            total += fineHistory[i];

        return total;
    }
}

class FineStudentMemberQ3 extends FineLibraryMemberQ3 {
    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }

    void applyFine(int amount) {
        chargeFine(amount);
    }
}

public class StudentFineLedger {
    public static void main(String[] args) {
        FineStudentMemberQ3 student = new FineStudentMemberQ3();

        student.applyFine(100);
        System.out.println(student.getTotalFine());

        int[] history = student.getFineHistory();
        history[0] = 999;

        System.out.println(Arrays.toString(student.getFineHistory()));
    }
}