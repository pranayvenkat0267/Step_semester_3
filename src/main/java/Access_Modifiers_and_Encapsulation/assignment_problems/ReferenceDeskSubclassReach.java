package Access_Modifiers_and_Encapsulation.assignment_problems;

 public class ReferenceDeskSubclassReach {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        if (fieldModifier.equals("private"))
            return "DENIED";

        if (fieldModifier.equals("default"))
            return "DENIED";

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS"))
                return "ALLOWED";

            if (accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"))
                return "DENIED";
        }

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String result =
                    classifyAccess(
                            attempts[i][0],
                            attempts[i][1]);

            if (result.equals("DENIED")) {

                return attempts[i][0]
                        + " via "
                        + attempts[i][1]
                        + " (attempt #"
                        + (i + 1)
                        + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {

        String[][] attempts = {

                {"public",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

                {"protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

                {"protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
                firstDeniedAttempt(attempts));
    }
}
