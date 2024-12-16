import java.util.*;

abstract class Account {
    String customerName;
    int accountNumber;
    double balance;
    String accountType;

    Account(String customerName, int accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    abstract void computeInterest();

    abstract void withdraw(double amount);
}

class SavAcct extends Account {
    final double interestRate = 0.04;

    SavAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

    @Override
    void computeInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added. New balance: " + balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurAcct extends Account {
    double minBalance = 1000.00;
    double charge = 50.00;
    double[] chequeTransactions = new double[100];
    int chequeId = 0;

    CurAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    @Override
    void computeInterest() {
        System.out.println("Interest cannot be calculated for a Current Account.");
    }

    @Override
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            if (balance >= minBalance) {
                System.out.println("The updated balance is: " + balance);
            } else {
                balance -= charge;
                System.out.println("Penalty of 50.0 has been deducted. The new balance is: " + balance);
            }
            chequeTransactions[chequeId] = amount;
            chequeId++;
        } else {
            System.out.println("Insufficient balance. The withdrawal amount is greater than balance.");
        }
    }

    void displayTransactions() {
        for (int i = 0; i < chequeId; i++) {
            System.out.println("Transaction " + (i + 1) + ": " + chequeTransactions[i]);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter account type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        int choice = input.nextInt();
        input.nextLine();

        System.out.println("Enter your name:");
        String name = input.nextLine();

        System.out.println("Enter your account number:");
        int accountNumber = input.nextInt();

        System.out.println("Enter the initial balance:");
        double balance = input.nextDouble();

        Account account;

        if (choice == 1) {
            account = new SavAcct(name, accountNumber, balance);
        } else {
            account = new CurAcct(name, accountNumber, balance);
        }

        int exit = 0;

        while (exit != 1) {
            System.out.println("\nEnter the function to be done:");
            System.out.println("1. Deposit");
            System.out.println("2. Display balance");
            System.out.println("3. Compute and deposit interest");
            System.out.println("4. Withdrawal");
            System.out.println("5. Exit");

            int func = input.nextInt();

            switch (func) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depAmount = input.nextDouble();
                    account.deposit(depAmount);
                    break;

                case 2:
                    account.displayBalance();
                    break;

                case 3:
                    account.computeInterest();
                    break;

                case 4:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 5:
                    exit = 1;
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid input");
            }

            if (choice == 2) {
                ((CurAcct) account).displayTransactions();
            }
        }
        System.out.print("Chethan K S\n1BM23CS074");
        input.close();
    }
}
