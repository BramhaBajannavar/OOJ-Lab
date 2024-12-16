import java.util.Scanner;

class Account {
    String customer_name;
    int account_number;
    String account_type;
    int balance;

    Account(String name, int no, String type, int balance) {
        this.customer_name = name;
        this.account_number = no;
        this.account_type = type;
        this.balance = balance;
    }
}

class Curr_act extends Account {
    int min_balance = 5000;
    int charge = 100;

    Curr_act(String name, int no, String type, int balance) {
        super(name, no, type, balance);
    }

    void deposit() {
        System.out.println("Enter deposit amount:");
        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        balance += x;
        System.out.println("Deposit successful!");
    }

    void curr_balance() {
        System.out.println("Current balance: " + balance);
    }

    void check() {
        if (balance < min_balance) {
            balance -= charge;
            System.out.println("Service charge of 100 deducted due to low balance.");
        }
    }
}

class Sav_act extends Account {
    int min_balance = 5000;
    double interest_rate = 5.0;

    Sav_act(String name, int no, String type, int balance) {
        super(name, no, type, balance);
    }

    void withdraw() {
        System.out.println("Enter withdrawal amount:");
        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        if (balance - x < min_balance) {
            System.out.println("Insufficient balance! Minimum balance of 5000 required.");
        } else {
            balance -= x;
            System.out.println("Withdrawal successful!");
        }
    }

    void curr_balance() {
        System.out.println("Current balance: " + balance);
    }

    void add_interest() {
        System.out.println("Adding interest to the account...");
        balance += (int) (balance * (interest_rate / 100));
        System.out.println("Interest added. Current balance: " + balance);
    }
}

public class Bank {
    public static void main(String[] args) {

        Curr_act acc1 = new Curr_act("John", 1234, "Current", 10000);
        Sav_act acc2 = new Sav_act("Doe", 5678, "Savings", 20000);


        System.out.println("\n-- Current Account Operations --");
        acc1.deposit();
        acc1.curr_balance();
        acc1.check();
        acc1.curr_balance();


        System.out.println("\n-- Savings Account Operations --");
        acc2.withdraw();
        acc2.curr_balance();
        acc2.add_interest();
        acc2.curr_balance();
    }
}
