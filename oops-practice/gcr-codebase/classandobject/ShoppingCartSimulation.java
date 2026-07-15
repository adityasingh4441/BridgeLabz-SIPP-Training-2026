import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
            System.out.println("Item added to cart");
        } else {
            System.out.println("Invalid quantity");
        }
    }

    void removeItem(int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity");
        } else if (quantity <= this.quantity) {
            this.quantity -= quantity;
            System.out.println("Item removed from cart");
        } else {
            System.out.println("Cannot remove more than available quantity");
        }
    }

    double calculateTotalCost() {
        return price * quantity;
    }

    void displayTotalCost() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

public class ShoppingCartSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter initial quantity: ");
        int quantity = scanner.nextInt();

        CartItem cartItem = new CartItem(itemName, price, quantity);

        System.out.print("Enter quantity to add: ");
        int addQuantity = scanner.nextInt();
        cartItem.addItem(addQuantity);

        System.out.print("Enter quantity to remove: ");
        int removeQuantity = scanner.nextInt();
        cartItem.removeItem(removeQuantity);

        cartItem.displayTotalCost();
    }
}
