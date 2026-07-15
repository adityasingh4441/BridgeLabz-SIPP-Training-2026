public class BankingSystem {
    static abstract class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

        void displayAccountDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Holder Name: " + holderName);
            System.out.println("Balance: " + balance);
        }

        abstract double calculateInterest();
    }

    static class SavingsAccount extends BankAccount {
        private double interestRate;

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        @Override
        double calculateInterest() {
            return getBalance() * interestRate / 100;
        }
    }

    static class CurrentAccount extends BankAccount {
        private double monthlyBonusRate;

        public double getMonthlyBonusRate() {
            return monthlyBonusRate;
        }

        public void setMonthlyBonusRate(double monthlyBonusRate) {
            this.monthlyBonusRate = monthlyBonusRate;
        }

        @Override
        double calculateInterest() {
            return getBalance() * monthlyBonusRate / 100;
        }
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber("SA101");
        savingsAccount.setHolderName("Amit");
        savingsAccount.setBalance(10000);
        savingsAccount.setInterestRate(4);
        savingsAccount.deposit(2000);
        savingsAccount.withdraw(1500);

        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber("CA201");
        currentAccount.setHolderName("Neha");
        currentAccount.setBalance(25000);
        currentAccount.setMonthlyBonusRate(1.5);
        currentAccount.deposit(5000);
        currentAccount.withdraw(3000);

        savingsAccount.displayAccountDetails();
        System.out.println("Interest: " + savingsAccount.calculateInterest());

        currentAccount.displayAccountDetails();
        System.out.println("Interest: " + currentAccount.calculateInterest());
    }
}
