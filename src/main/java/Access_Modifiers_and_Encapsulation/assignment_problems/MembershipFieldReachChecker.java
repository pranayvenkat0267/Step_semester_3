package Access_Modifiers_and_Encapsulation.assignment_problems;

class LibraryMember {

    private String membershipPin;

    String branchCode;              // default

    protected double finesOwed;     // protected

    public String displayName;      // public

    LibraryMember(String pin,
                  String branch,
                  double fines,
                  String name) {

        membershipPin = pin;
        branchCode = branch;
        finesOwed = fines;
        displayName = name;
    }
}

public class MembershipFieldReachChecker {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        if (fieldModifier.equals("private")) {

            return accessorContext.equals("SAME_CLASS")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("default")) {

            return accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("protected")) {

            return accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        String[] modifiers = {
                "private",
                "default",
                "protected",
                "public"
        };

        StringBuilder result = new StringBuilder();

        for (String modifier : modifiers) {

            int allowed = 0;
            int denied = 0;

            for (String[] attempt : attempts) {

                if (attempt[0].equals(modifier)) {

                    String answer =
                            classifyAccess(
                                    attempt[0],
                                    attempt[1]);

                    if (answer.equals("ALLOWED"))
                        allowed++;
                    else
                        denied++;
                }
            }

            if (result.length() > 0)
                result.append("\n");

            result.append(modifier)
                    .append(": ")
                    .append(allowed)
                    .append(" allowed / ")
                    .append(denied)
                    .append(" denied");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String[][] attempts = {

                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},

                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},

                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},

                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
                classifyAccess(
                        "private",
                        "SAME_CLASS"));

        System.out.println(
                classifyAccess(
                        "protected",
                        "DIFFERENT_PACKAGE"));

        System.out.println(
                summarizeByModifier(attempts));
    }
}