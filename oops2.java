class Car {

    String brand;
    int year;

    Car(String b, int y) {
        brand = b;
        year = y;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}

public class oops2 {
    public static void main(String[] args) {

        Car c1 = new Car("Toyota", 2024);

        c1.display();
    }
}