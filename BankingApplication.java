import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class BankingApplication {
    private final Map<String, Double> accounts;
    public BankingApplication() {
        accounts = new HashMap<>();
    }
    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        System.out.println("Account created successfully.");
    }
    public void deposit(String accountNumber, double amount) {

        if (accounts.containsKey(accountNumber)) {

            double currentBalance = accounts.get(accountNumber);

            double newBalance = currentBalance + amount;

            accounts.put(accountNumber, newBalance);

            System.out.println("Deposit successful. New balance: $" + newBalance);

        } else {

            System.out.println("Account not found.");

        }

    }



    public void withdraw(String accountNumber, double amount) {

        if (accounts.containsKey(accountNumber)) {

            double currentBalance = accounts.get(accountNumber);

            if (currentBalance >= amount) {

                double newBalance = currentBalance - amount;

                accounts.put(accountNumber, newBalance);

                System.out.println("Withdrawal successful. New balance: $" + newBalance);

            } else {

                System.out.println("Insufficient funds.");

            }

        } else {

            System.out.println("Account not found.");

        }

    }



    public void checkBalance(String accountNumber) {

        if (accounts.containsKey(accountNumber)) {

            double balance = accounts.get(accountNumber);

            System.out.println("Current balance: $" + balance);

        } else {

            System.out.println("Account not found.");

        }

    }



    public static void main(String[] args) {

        BankingApplication app = new BankingApplication();

        Scanner scanner = new Scanner(System.in);



        int choice;

        do {

            System.out.println("\nWelcome to the Banking Application");

            System.out.println("1. Create Account");

            System.out.println("2. Deposit");

            System.out.println("3. Withdraw");

            System.out.println("4. Check Balance");

            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");

            choice = scanner.nextInt();

            scanner.nextLine(); 



            switch (choice) {

                case 1:

                    System.out.print("Enter account number: ");

                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter initial balance: ");

                    double initialBalance = scanner.nextDouble();

                    scanner.nextLine(); 

                    app.createAccount(accountNumber, initialBalance);

                    break;

                case 2:

                    System.out.print("Enter account number: ");

                    accountNumber = scanner.nextLine();

                    System.out.print("Enter amount to deposit: ");

                    double depositAmount = scanner.nextDouble();

                    scanner.nextLine(); 

                    app.deposit(accountNumber, depositAmount);

                    break;

                case 3:

                    System.out.print("Enter account number: ");

                    accountNumber = scanner.nextLine();

                    System.out.print("Enter amount to withdraw: ");

                    double withdrawAmount = scanner.nextDouble();

                    scanner.nextLine(); 

                    app.withdraw(accountNumber, withdrawAmount);

                    break;

                case 4:

                    System.out.print("Enter account number: ");

                    accountNumber = scanner.nextLine();

                    app.checkBalance(accountNumber);

                    break;

                case 5:

                    System.out.println("Exiting the banking application...");

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 5);

    }

}
