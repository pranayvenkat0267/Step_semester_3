package OOPFundamental.class_problems;

class IdCard {

    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        IdCard ravi = new IdCard("Ravi", 0);

        // Both variables point to the same object
        IdCard duplicate = ravi;

        // Changing through duplicate changes the same object
        duplicate.booksIssued = 3;

        System.out.println(
                "Ravi's booksIssued (via first variable): "
                        + ravi.booksIssued);

        System.out.println(
                "duplicate == ravi: " + (duplicate == ravi));

        // A completely separate object
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println(
                "separate == ravi: " + (separate == ravi));
    }
}
