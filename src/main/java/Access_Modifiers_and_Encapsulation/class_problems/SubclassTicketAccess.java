package Access_Modifiers_and_Encapsulation.class_problems;

public class SubclassTicketAccess {

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

    public static void main(String[] args) {

        System.out.println(
                classifyAccess(
                        "protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println(
                classifyAccess(
                        "protected",
                        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}