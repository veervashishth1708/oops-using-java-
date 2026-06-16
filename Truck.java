public class Truck {
    String brand;
    String model;
    int loadCapacity;

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Load Capacity: " + loadCapacity + " kg");
    }

    public static void main(String[] args) {
        Truck t = new Truck();

        t.brand = "Tata";
        t.model = "Signa 5530";
        t.loadCapacity = 55000;

        t.display();
    }
}