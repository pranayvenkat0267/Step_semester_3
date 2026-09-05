package main.java.JavaStringsConcept.assignment_problems;

import java.util.Scanner;

public class TrafficStreak {

    static void findLongestStreak(String signalLog) {

        int currentCount = 1;
        int maxCount = 1;
        char longestChar = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                longestChar = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestChar
                + "' repeated " + maxCount + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}