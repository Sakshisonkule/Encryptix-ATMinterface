import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    // Constructor to initialize ATM with a BankAccount
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to handle user choice
    public void processTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Your current balance is: $" + account.checkBalance());
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.00); // Example initial balance
        ATM atmMachine = new ATM(userAccount);

        int userChoice = 0;

        // Loop to keep the ATM running until user chooses to exit
        while (userChoice != 4) {
            atmMachine.displayMenu();

            // Input user choice
            System.out.print("Enter your choice (1-4): ");
            userChoice = scanner.nextInt();

            // Process the chosen option
            atmMachine.processTransaction(userChoice, scanner);
        }

        // Close the scanner
        scanner.close();
    }
}
    

