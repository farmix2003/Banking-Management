import java.util.Objects;
import java.util.Scanner;

public class Main {
    public enum Transactions {
        WITHDRAW,
        DEPOSIT,
        CHECK_BALANCE
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "Farrukh";
        int password = 20030825;
        String inputUsername;
        int inputPassword;

        System.out.println("Enter a username:");
        inputUsername = scanner.next();

        while (!Objects.equals(inputUsername, username)) {
            System.out.println("Wrong username. Try again");
            System.out.print("Username: ");
            inputUsername = scanner.next();
        }

        System.out.println("Enter a password:");
        while (true) {
            try {
                inputPassword = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print("Password: ");
            }
        }
        while (inputPassword != password) {
            System.out.println("Wrong password. Try again");
            System.out.print("Password: ");
            inputPassword = Integer.parseInt(scanner.next());
        }
        System.out.println("Welcome back " + inputUsername);
        performTransactions(scanner);
    }

    public static void performTransactions(Scanner scanner) {
        int total = 300;

        while (true) {
            System.out.println("Choose a transaction:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    total = performTransaction(Transactions.WITHDRAW, total, scanner);
                    break;
                case 2:
                    total = performTransaction(Transactions.DEPOSIT, total, scanner);
                    break;
                case 3:
                    performTransaction(Transactions.CHECK_BALANCE, total, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }

    private static int performTransaction(Transactions transactions, int total, Scanner scanner) {
        switch (transactions) {
            case WITHDRAW:
                System.out.println("Enter amount to withdraw:");
                int withdrawAmount = scanner.nextInt();
                if (withdrawAmount > total) {
                    System.out.println("Your balance is not enough. Please try with a smaller amount!");
                } else {
                    total -= withdrawAmount;
                    System.out.println("You withdrew " + withdrawAmount + "$ from your account");
                }
                break;
            case DEPOSIT:
                System.out.println("Enter amount to deposit to your account:");
                int depositAmount = scanner.nextInt();
                if (depositAmount <= 0) {
                    System.out.println("Invalid amount. Please try again with a valid amount of money!");
                } else {
                    total += depositAmount;
                    System.out.println("You successfully deposited " + depositAmount + "$ to your account.");
                }
                break;
            case CHECK_BALANCE:
                System.out.println("Your current balance: " + total + "$");
                break;
            default:
                System.out.println("Thank you for your transaction!");
        }
        return total;
    }
}
