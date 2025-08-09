import java.util.Scanner;

class Product {
    String name = "Wireless Mouse";
    double price = 799.50;
    int quantityAvailable = 10;
    boolean inStock = true;

    void showDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity Available: " + quantityAvailable);
        System.out.println("In Stock: " + inStock);
    }

    double calculateTotal(int quantity) {
        return price * quantity;
    }
}

public class ECommerceShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        char continueChoice;

        do {
            System.out.println("\n---- E-commerce Shopping Cart ----");
            product.showDetails();

            System.out.print("Enter quantity to purchase: ");
            int quantity = sc.nextInt();

            if (quantity > product.quantityAvailable || quantity <= 0) {
                System.out.println("Invalid quantity or out of stock.");
            } else {
                double total = product.calculateTotal(quantity);

                // Apply discount if applicable
                double discount = 0;
                if (total >= 1000) {
                    discount = total * 0.10; // 10% discount
                    System.out.println("Discount Applied: ₹" + discount);
                }

                // Determine shipping charge
                double shippingCharge = 0;
                if (total < 500) {
                    shippingCharge = 50; // Flat shipping charge
                    System.out.println("Shipping Charge: ₹" + shippingCharge);
                } else {
                    System.out.println("Free Shipping!");
                }

                double finalBill = total - discount + shippingCharge;
                System.out.println("Total Bill: ₹" + finalBill);

                // Update stock
                product.quantityAvailable -= quantity;
                if (product.quantityAvailable == 0) {
                    product.inStock = false;
                }
            }

            System.out.print("Do you want to purchase again? (y/n): ");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'y' || continueChoice == 'Y');

        sc.close();
    }
}
