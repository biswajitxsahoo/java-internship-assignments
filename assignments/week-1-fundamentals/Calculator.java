import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter operation (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        if (op == '+') {
            System.out.println("Result: " + (num1 + num2));
        } 
        
        else if (op == '-') {
            System.out.println("Result: " + (num1 - num2));
        } 
        
        else if (op == '*') {
            System.out.println("Result: " + (num1 * num2));
        } 
        
        else if (op == '/') {
            if (num2 == 0) {
                System.out.println("Cannot divide by zero!");
            } 
            else {
                System.out.println("Result: " + (num1 / num2));
            }
        } 
        
        else {
            System.out.println("Invalid operation!");
        }

        scanner.close();
    }
}