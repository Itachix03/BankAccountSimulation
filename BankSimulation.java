import java.util.ArrayList;
import java.util.Scanner;

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", "Himanshu Vaishnav");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bank Account Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter amount to deposit: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        account.deposit(amount);
                    }
                    case 2 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        account.withdraw(amount);
                    }
                    case 3 -> account.displayBalance();
                    case 4 -> account.displayTransactionHistory();
                    case 5 -> System.out.println("Exiting Bank Simulation. Goodbye!");
                    default -> System.out.println("Invalid choice. Please select between 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }

        } while (choice != 5);

        scanner.close();
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for " + accountHolder + " (Acc No: " + accountNumber + ")");
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited ₹" + amount);
        transactionHistory.add("Deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew ₹" + amount);
        transactionHistory.add("Withdrew ₹" + amount);
    }

    public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }
}
