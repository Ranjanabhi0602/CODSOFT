import java.util.Scanner;

class ATM {
    private double balance;
    private String transactionHistory;

    public ATM() {
        balance = 0.0;
        transactionHistory = "";
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ATM INTERFACE");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transactions History");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdraw: -$" + amount + "\n";
            System.out.println("Withdrawal successful. Please take your cash.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        balance += amount;
        transactionHistory += "Deposit: +$" + amount + "\n";
        System.out.println("Deposit successful.");
    }

    private void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory += "Transfer: -$" + amount + "\n";
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void viewTransactionHistory() {
        System.out.println("Transaction History:\n" + transactionHistory);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.showMenu();
    }
}
