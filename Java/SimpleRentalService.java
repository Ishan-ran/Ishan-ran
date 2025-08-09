import java.util.Scanner;

class Car {
    String brand = "Toyota";
    double ratePerDay = 1200;
    int seats = 5;

    void showDetails() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Rate per day: ₹" + ratePerDay);
        System.out.println("Seats: " + seats);
    }

    double calculateRent(int days) {
        return ratePerDay * days;
    }
}

class Bike {
    String brand = "Bajaj";
    double ratePerDay = 500;
    boolean helmetIncluded = true;

    void showDetails() {
        System.out.println("Bike Brand: " + brand);
        System.out.println("Rate per day: ₹" + ratePerDay);
        System.out.println("Helmet included: " + helmetIncluded);
    }

    double calculateRent(int days) {
        return ratePerDay * days;
    }
}

class Truck {
    String brand = "Tata";
    double ratePerDay = 2500;
    double capacity = 10.0;

    void showDetails() {
        System.out.println("Truck Brand: " + brand);
        System.out.println("Rate per day: ₹" + ratePerDay);
        System.out.println("Load capacity: " + capacity + " tons");
    }

    double calculateRent(int days) {
        return ratePerDay * days;
    }
}


public class SimpleRentalService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char continueChoice;

        do {
            System.out.println("Choose a vehicle: 1.Car  2.Bike  3.Truck");
            int choice = sc.nextInt();

            if (choice == 1) {
                Car car = new Car();
                car.showDetails();
                System.out.print("Enter rental days: \n");
                int days = sc.nextInt();
                System.out.println("Total rent: ₹" + car.calculateRent(days));
            } else if (choice == 2) {
                Bike bike = new Bike();
                bike.showDetails();
                System.out.print("Enter rental days: ");
                int days = sc.nextInt();
                System.out.println("Total rent: ₹" + bike.calculateRent(days));
            } else if (choice == 3) {
                Truck truck = new Truck();
                truck.showDetails();
                System.out.print("Enter rental days: ");
                int days = sc.nextInt();
                System.out.println("Total rent: ₹" + truck.calculateRent(days));
            } else {
                System.out.println("Invalid choice!");
            }

            System.out.print("Do you want to rent another vehicle? (y/n): ");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        sc.close();
    }
}