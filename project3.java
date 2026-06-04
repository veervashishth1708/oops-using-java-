import java.util.Scanner;

abstract class WasteManagement {
    protected double weight;
    protected double fixedCharges;
    protected double discount;

    WasteManagement(double weight, double fixedCharges, double discount) {
        this.weight = weight;
        this.fixedCharges = fixedCharges;
        this.discount = discount;
    }

    abstract double calculateCost();
}

class HouseholdWaste extends WasteManagement {

    HouseholdWaste(double weight, double fixedCharges, double discount) {
        super(weight, fixedCharges, discount);
    }

    double calculateCost() {
        double baseCost = 2.0 * weight;
        return (baseCost + fixedCharges) * (1 - discount / 100);
    }
}

class RestaurantWaste extends WasteManagement {

    RestaurantWaste(double weight, double fixedCharges, double discount) {
        super(weight, fixedCharges, discount);
    }

    double calculateCost() {
        double baseCost = 3.0 * weight;
        return (baseCost + fixedCharges) * (1 - discount / 100);
    }
}

class IndustrialWaste extends WasteManagement {

    IndustrialWaste(double weight, double fixedCharges, double discount) {
        super(weight, fixedCharges, discount);
    }

    double calculateCost() {
        double baseCost = 6.0 * weight;
        return (baseCost + fixedCharges) * (1 - discount / 100);
    }
}

public class project3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        double w = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();

        WasteManagement waste = null;

        switch (t) {
            case 1:
                waste = new HouseholdWaste(w, c, d);
                break;

            case 2:
                waste = new RestaurantWaste(w, c, d);
                break;

            case 3:
                waste = new IndustrialWaste(w, c, d);
                break;

            default:
                System.out.println("Invalid Waste Type");
                sc.close();
                return;
        }

        System.out.printf("%.2f", waste.calculateCost());

        sc.close();
    }
}