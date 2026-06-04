import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class project5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String restaurantName = "THE FOOD PALACE";
        String address = "GT Road, Panipat, Haryana";
        String gstNo = "06ABCDE1234F1Z5";

        String[] itemName = {
                "Burger",
                "Pizza",
                "Pasta",
                "French Fries",
                "Cold Drink",
                "Coffee",
                "Sandwich",
                "Ice Cream"
        };

        double[] itemPrice = {
                120, 250, 180, 100,
                60, 80, 90, 70
        };

        int[] quantity = new int[itemName.length];

        System.out.println("======================================");
        System.out.println("        " + restaurantName);
        System.out.println("======================================");

        System.out.print("Enter Customer Name : ");
        String customer = sc.nextLine();

        System.out.print("Enter Table Number  : ");
        int tableNo = sc.nextInt();

        int choice;

        do {

            System.out.println("\n------------ MENU ------------");

            for (int i = 0; i < itemName.length; i++) {
                System.out.println((i + 1) + ". "
                        + itemName[i]
                        + " - Rs." + itemPrice[i]);
            }

            System.out.println("0. Generate Bill");

            System.out.print("\nEnter Choice : ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= itemName.length) {

                System.out.print("Enter Quantity : ");
                int qty = sc.nextInt();

                quantity[choice - 1] += qty;

                System.out.println("Item Added Successfully!");
            }

        } while (choice != 0);

        double subtotal = 0;

        for (int i = 0; i < itemName.length; i++) {
            subtotal += quantity[i] * itemPrice[i];
        }

        double serviceCharge = subtotal * 0.10;
        double gst = subtotal * 0.05;
        double grandTotal = subtotal + serviceCharge + gst;

        int billNo = (int)(Math.random() * 90000) + 10000;

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("\n\n");
        System.out.println("==================================================");
        System.out.println("                " + restaurantName);
        System.out.println("==================================================");
        System.out.println(address);
        System.out.println("GSTIN : " + gstNo);
        System.out.println("Bill No : " + billNo);
        System.out.println("Date    : " + format.format(now));
        System.out.println("Customer: " + customer);
        System.out.println("Table No: " + tableNo);

        System.out.println("--------------------------------------------------");
        System.out.printf("%-15s %-10s %-8s %-10s%n",
                "Item", "Price", "Qty", "Amount");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < itemName.length; i++) {

            if (quantity[i] > 0) {

                double amount =
                        quantity[i] * itemPrice[i];

                System.out.printf("%-15s %-10.2f %-8d %-10.2f%n",
                        itemName[i],
                        itemPrice[i],
                        quantity[i],
                        amount);
            }
        }

        System.out.println("--------------------------------------------------");

        System.out.printf("%35s : Rs. %.2f%n",
                "Sub Total", subtotal);

        System.out.printf("%35s : Rs. %.2f%n",
                "Service Charge (10%)", serviceCharge);

        System.out.printf("%35s : Rs. %.2f%n",
                "GST (5%)", gst);

        System.out.println("--------------------------------------------------");

        System.out.printf("%35s : Rs. %.2f%n",
                "GRAND TOTAL", grandTotal);

        System.out.println("==================================================");
        System.out.println("         THANK YOU FOR DINING WITH US");
        System.out.println("                VISIT AGAIN");
        System.out.println("==================================================");

        sc.close();
    }
}