import java.util.Scanner;

class ElectricityBill {
    private String customerName;
    private int units;
    private double billAmount;

    ElectricityBill(String customerName, int units) {
        this.customerName = customerName;
        this.units = units;
    }

    public void calculateBill() {

        if (units <= 100) {
            billAmount = units * 1.50;
        }
        else if (units <= 300) {
            billAmount = (100 * 1.50) + ((units - 100) * 2.50);
        }
        else if (units <= 500) {
            billAmount = (100 * 1.50) + (200 * 2.50)
                    + ((units - 300) * 4.00);
        }
        else {
            billAmount = (100 * 1.50) + (200 * 2.50)
                    + (200 * 4.00)
                    + ((units - 500) * 6.00);
        }

        // Fixed meter charge
        billAmount += 100;
    }

    public void displayBill() {
        System.out.println("\n========== ELECTRICITY BILL ==========");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Units Consumed: " + units);
        System.out.printf("Total Bill    : Rs. %.2f%n", billAmount);
        System.out.println("======================================");
    }
}

public class project4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        ElectricityBill bill = new ElectricityBill(name, units);

        bill.calculateBill();
        bill.displayBill();

        sc.close();
    }
}