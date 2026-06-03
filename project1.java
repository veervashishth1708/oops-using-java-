import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("----------------------------------");
        System.out.println("Product ID : " + id);
        System.out.println("Product Name : " + name);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price : ₹" + price);
    }
}

public class project1 {

    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        inventory.add(new Product(id, name, quantity, price));

        System.out.println("Product Added Successfully!");
    }

    public static void viewProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty!");
            return;
        }

        System.out.println("\n===== PRODUCT LIST =====");

        for (Product p : inventory) {
            p.display();
        }
    }

    public static void searchProduct() {

        System.out.print("Enter Product ID to Search: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                System.out.println("Product Found!");
                p.display();
                return;
            }
        }

        System.out.println("Product Not Found!");
    }

    public static void updateStock() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {

                System.out.print("Enter New Quantity: ");
                p.quantity = sc.nextInt();

                System.out.println("Stock Updated Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found!");
    }

    public static void deleteProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                inventory.remove(p);

                System.out.println("Product Deleted Successfully!");
                return;
            }
        }

        System.out.println("Product Not Found!");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateStock();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}