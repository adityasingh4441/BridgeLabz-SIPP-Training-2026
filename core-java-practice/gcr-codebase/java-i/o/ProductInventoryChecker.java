import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductInventoryChecker {
    public static void checkOutOfStockItems(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("-");

                if (data.length == 2) {
                    String productName = data[0].trim();
                    int quantity = Integer.parseInt(data[1].trim());

                    if (quantity == 0) {
                        System.out.println(productName + " is out of stock");
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("Error reading inventory file");
        } catch (NumberFormatException exception) {
            System.out.println("Invalid quantity in inventory file");
        }
    }

    public static void main(String[] args) {
        checkOutOfStockItems("inventory.txt");
    }
}
