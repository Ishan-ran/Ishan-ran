import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SimpleDayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter day: ");
        int day = sc.nextInt();

        System.out.println("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.println("Enter year: ");
        int year = sc.nextInt();

        try {
            // Create calendar (months start from 0 in Java Calendar)
            Calendar calendar = new GregorianCalendar(year, month - 1, day);

            String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 1 for Sunday, 2 for Monday, etc.

            System.out.println("The day is: " + days[dayOfWeek - 1]);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date entered. Please check day, month, and year.");
        }
    }
}
