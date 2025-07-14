import java.util.Scanner;

// BankAccount class represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Deposit amount should be greater than zero.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            if (amount <= 0) {
                System.out.println("Withdrawal amount should be greater than zero.");
            } else {
                System.out.println("Insufficient balance.");
            }
            return false;
        }
    }
}

// ATM class represents the ATM machine and its user interface
public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    public void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Your account balance is: $" + balance);
    }

    public void deposit() {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        if (bankAccount.deposit(amount)) {
            System.out.println("$" + amount + " has been deposited into your account.");
        }
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        if (bankAccount.withdraw(amount)) {
            System.out.println("$" + amount + " has been withdrawn from your account.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initialize account with balance $1000
        ATM atm = new ATM(account);
        atm.run();
    }
}

