class Employee {

    String company = "Google";

    void showCompany() {
        System.out.println("Company: " + company);
    }
}

class Developer extends Employee {

    int salary = 100000;

    void showSalary() {
        System.out.println("Salary: " + salary);
    }
}

public class Inheritance6 {
    public static void main(String[] args) {

        Developer d = new Developer();

        d.showCompany();
        d.showSalary();
    }
}