import java.util.Scanner;

public class BankTransactionSystem {
    private double balance;

    public BankTransactionSystem(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        BankTransactionSystem account = new BankTransactionSystem(balance);

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException exception) {
            System.out.println(exception.getMessage());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    
        scanner.close();}
}
