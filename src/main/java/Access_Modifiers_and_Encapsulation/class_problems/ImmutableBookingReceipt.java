package Access_Modifiers_and_Encapsulation.class_problems;

import java.util.Arrays;

class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String getBookingId() {
        return bookingId;
    }

    // Defensive copy
    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    // Returns a new object instead of changing current object
    public BookingReceipt withUpdatedSeat(int index, String newSeat) {

        String[] newSeats = seatNumbers.clone();

        if (index >= 0 && index < newSeats.length) {
            newSeats[index] = newSeat;
        }

        return new BookingReceipt(bookingId, newSeats);
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(String bookingId,
                               String[] seatNumbers,
                               int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}

public class ImmutableBookingReceipt {

    static String processNightlySettlement(
            BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (BookingReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt r =
                new BookingReceipt(
                        "CH-1001",
                        new String[]{"A1", "A2"});

        String[] seats = r.getSeatNumbers();

        seats[0] = "X";

        System.out.println(
                Arrays.toString(r.getSeatNumbers()));

        BookingReceipt updated =
                r.withUpdatedSeat(1, "A3");

        System.out.println(
                Arrays.toString(r.getSeatNumbers()));

        System.out.println(
                Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] receipts = {
                new GroupBookingReceipt(
                        "CH-2002",
                        new String[]{"B1", "B2"},
                        2),
                null,
                new BookingReceipt(
                        "CH-3003",
                        new String[]{"C1"})
        };

        System.out.println(
                processNightlySettlement(receipts));
    }
}