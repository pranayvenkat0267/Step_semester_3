package OOPFundamental.assignment_problems;

class HallTicket {

    String studentName;
    int seatNumber;

    public HallTicket(String studentName,
                      int seatNumber) {

        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // First object
        HallTicket priya =
                new HallTicket("Priya", 0);

        // Reference copy
        HallTicket copy = priya;

        // Change through second reference
        copy.seatNumber = 45;

        System.out.println(
                "Priya's seatNumber (via first variable): "
                        + priya.seatNumber);

        System.out.println(
                "copy == priya: " + (copy == priya));

        // Separate object
        HallTicket separate =
                new HallTicket("Priya", 45);

        System.out.println(
                "separate == priya: "
                        + (separate == priya));
    }
}
