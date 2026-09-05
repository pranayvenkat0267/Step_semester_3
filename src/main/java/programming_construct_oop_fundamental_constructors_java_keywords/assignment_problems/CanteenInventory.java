package programming_construct_oop_fundamental_constructors_java_keywords.assignment_problems;

public class CanteenInventory {

    static class Item {

        String itemName;
        int stock;

        public Item(String itemName, int stock) {
            this.itemName = itemName;
            this.stock = stock;
        }

        public void restock(int stock) {
            this.stock += stock;
        }

        public void printStock() {
            System.out.println(itemName +
                    " | Final Stock: " + stock);
        }
    }

    public static void main(String[] args) {

        Item[] items = {
                new Item("Samosa", 15),
                new Item("Tea Powder", 40),
                new Item("Bread", 8),
                new Item("Biscuit Packs", 25)
        };

        int stock = 20;

        for (Item item : items) {
            item.restock(stock);
            item.printStock();
        }
    }
}