import java.util.Scanner;

class Book {
    String title = "Introduction to Java";
    String author = "James Gosling";
    double ratePerDay = 10;
    boolean isIssued = false;

    void showDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Rent per day: ₹" + ratePerDay);
        System.out.println("Currently Issued: " + isIssued);
    }

    double calculateRent(int days) {
        return ratePerDay * days;
    }

    void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is already issued to someone else.");
        }
    }

    void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book was not issued.");
        }
    }
}

public class CollegeLibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book = new Book();
        char continueChoice;

        System.out.print("Enter admin PIN to access the library system: ");
        int pin = sc.nextInt();
        if (pin != 1234) {
            System.out.println("Unauthorized access detected! Exiting for security.");
            System.exit(0);
        }

        do {
            System.out.println("\n---- College Library Menu ----");
            System.out.println("1. View Book Details");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Calculate Rent");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                book.showDetails();
            } else if (choice == 2) {
                book.issueBook();
            } else if (choice == 3) {
                book.returnBook();
            } else if (choice == 4) {
                System.out.print("Enter rental days: ");
                int days = sc.nextInt();
                System.out.println("Total rent: ₹" + book.calculateRent(days));
            } else if (choice == 5) {
                System.out.println("Exiting system. Thank you!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }

            System.out.print("Do you want to continue? (y/n): ");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        sc.close();
    }
}
