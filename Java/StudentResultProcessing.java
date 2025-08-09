import java.util.Scanner;

class Student {
    String name = "Ananya";
    int rollNo = 101;
    double marks1;
    double marks2;
    double marks3;

    void inputMarks(double m1, double m2, double m3) {
        marks1 = m1;
        marks2 = m2;
        marks3 = m3;
    }

    double calculatePercentage() {
        double total = marks1 + marks2 + marks3;
        return (total / 300) * 100;
    }

    double calculateGradePoints(double percentage) {
        return percentage / 10; // Simple grade points out of 10
    }

    boolean checkPass() {
        return marks1 >= 35 && marks2 >= 35 && marks3 >= 35;
    }

    boolean isEligibleForScholarship(double percentage) {
        return percentage >= 85;
    }

    boolean isEligibleForMerit(double percentage) {
        return percentage >= 90;
    }

    void displayResult() {
        double percentage = calculatePercentage();
        double gradePoints = calculateGradePoints(percentage);

        System.out.println("\n---- Student Result ----");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade Points: " + gradePoints);

        if (checkPass()) {
            System.out.println("Status: Pass");
            if (isEligibleForScholarship(percentage)) {
                System.out.println("Scholarship: Eligible");
            } else {
                System.out.println("Scholarship: Not Eligible");
            }

            if (isEligibleForMerit(percentage)) {
                System.out.println("Merit List: Eligible");
            } else {
                System.out.println("Merit List: Not Eligible");
            }
        } else {
            System.out.println("Status: Fail");
            System.out.println("Scholarship: Not Eligible");
            System.out.println("Merit List: Not Eligible");
        }
    }
}

public class StudentResultProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        char continueChoice;

        do {
            System.out.print("Enter marks for Subject 1: ");
            double m1 = sc.nextDouble();
            System.out.print("Enter marks for Subject 2: ");
            double m2 = sc.nextDouble();
            System.out.print("Enter marks for Subject 3: ");
            double m3 = sc.nextDouble();

            student.inputMarks(m1, m2, m3);
            student.displayResult();

            System.out.print("\nDo you want to process another student? (y/n): ");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        sc.close();
    }
}
