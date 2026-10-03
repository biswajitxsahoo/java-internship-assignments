import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double balance = 0;
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Your current balance is: " + balance);
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                double deposit = scanner.nextDouble();
                balance = balance + deposit;
                System.out.println("Money deposited successfully!");
            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                double withdraw = scanner.nextDouble();
                
                if (withdraw > balance) {
                    System.out.println("Insufficient balance!");
                } else {
                    balance = balance - withdraw;
                    System.out.println("Money withdrawn successfully!");
                }
            } else if (choice == 4) {
                System.out.println("Thank you for using our bank!");
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}