import java.util.Scanner;

class BankAccount {
    String accountHolder = "Ravi Kumar";
    int accountNumber = 123456;
    double balance = 5000.0;

    void showDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully!");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class OnlineBankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        char continueChoice;

        System.out.print("Enter secure PIN to access your bank account: ");
        int pin = sc.nextInt();
        if (pin != 4321) {
            System.out.println("Unauthorized access! Exiting system.");
            System.exit(0);
        }

        do {
            System.out.println("\n---- Online Banking Menu ----");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                account.showDetails();
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amount = sc.nextDouble();
                account.deposit(amount);
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amount = sc.nextDouble();
                account.withdraw(amount);
            } else if (choice == 4) {
                System.out.println("Thank you for using Online Banking.");
                break;
            } else {
                System.out.println("Invalid choice!");
            }

            System.out.print("Do you want to perform another transaction? (y/n): ");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        sc.close();
    }
}
