import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void appendExpense(String category, double amount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.txt", true))) {
            writer.write(category + " - " + amount);
            writer.newLine();
            System.out.println("Expense saved successfully");
        } catch (IOException exception) {
            System.out.println("Error saving expense");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        appendExpense(category, amount);
    }
}
