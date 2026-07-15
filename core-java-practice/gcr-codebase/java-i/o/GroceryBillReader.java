import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void readBill(String fileName) {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            System.out.println("Total number of lines: " + lineCount);
        } catch (IOException exception) {
            System.out.println("Error reading bill file");
        }
    }

    public static void main(String[] args) {
        readBill("bill.txt");
    }
}
