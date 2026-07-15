import java.util.Scanner;

class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }
}

public class ItemInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item code: ");
        int itemCode = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Item item = new Item(itemCode, itemName, price);
        item.displayDetails();
        System.out.println("Total Cost: " + item.calculateTotalCost(quantity));
    }
}
