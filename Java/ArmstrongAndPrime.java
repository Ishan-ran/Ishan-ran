import java.util.Scanner;

public class ArmstrongAndPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Armstrong Number");
            System.out.println("2. Check Prime Number");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Armstrong number check
                    System.out.print("Enter a number to check if it is an Armstrong number: ");
                    int armNum = scanner.nextInt();
                    if (isArmstrong(armNum)) {
                        System.out.println(armNum + " is an Armstrong number.");
                    } else {
                        System.out.println(armNum + " is not an Armstrong number.");
                    }
                    break;

                case 2:
                    // Prime number check
                    System.out.print("Enter a number to check if it is a Prime number: ");
                    int primeNum = scanner.nextInt();
                    if (isPrime(primeNum)) {
                        System.out.println(primeNum + " is a Prime number.");
                    } else {
                        System.out.println(primeNum + " is not a Prime number.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close(); // Close scanner
    }

    // Method to check if a number is an Armstrong number
    public static boolean isArmstrong(int num) {
        int sum = 0, temp, remainder, digits = 0;

        temp = num;
        while (temp != 0) {
            temp /= 10;
            digits++;
        }

        temp = num;
        while (temp != 0) {
            remainder = temp % 10;
            sum += Math.pow(remainder, digits);
            temp /= 10;
        }

        return sum == num;
    }

    // Method to check if a number is Prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
