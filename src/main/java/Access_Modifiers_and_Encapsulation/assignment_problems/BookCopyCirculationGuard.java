package Access_Modifiers_and_Encapsulation.assignment_problems;

class BookInventory {

    private int copiesTotal;
    private int copiesAvailable;

    BookInventory(int totalCopies) {

        if (totalCopies <= 0) {
            throw new IllegalArgumentException(
                    "Invalid total copies");
        }

        copiesTotal = totalCopies;
        copiesAvailable = totalCopies;
    }

    void checkOut() {

        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    void checkIn() {

        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }
}

public class BookCopyCirculationGuard {

    public static void main(String[] args) {

        BookInventory b =
                new BookInventory(3);

        b.checkOut();
        b.checkOut();
        b.checkOut();

        // Rejected because no copy remains
        b.checkOut();

        System.out.println(
                b.getCopiesAvailable());

        b.checkIn();
        b.checkIn();
        b.checkIn();

        // Rejected because inventory is already full
        b.checkIn();

        System.out.println(
                b.getCopiesAvailable());
    }
}
