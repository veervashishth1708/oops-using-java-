import java.util.Scanner;

public class AreaCircle {
    public static void main(String[] args) {
        System.out.println("Area of circle : ");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Radius: ");
        double r = sc.nextDouble();

        double area = 3.14159 * r * r;

        System.out.println("Area = " + area);
    }
}