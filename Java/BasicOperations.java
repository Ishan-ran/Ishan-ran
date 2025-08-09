import java.util.Scanner;

public class BasicOperations {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Give number A:");
            int a = input.nextInt();
            
            System.out.println("Give number B:");
            int b = input.nextInt();
            
            System.out.println("Choose an operation:");
            System.out.println("1. Add the numbers");
            System.out.println("2. Subtract the numbers");
            System.out.print("Enter your choice (1 or 2): ");
            int choice = input.nextInt();
            
            switch (choice) {
                case 1 -> System.out.println("Result: " + (a + b));
                case 2 -> System.out.println("Result: " + (a - b));
                default -> System.out.println("Invalid choice!");
            }
        }
    }