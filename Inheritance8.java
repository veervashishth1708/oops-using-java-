class BankAccount {

    double balance = 5000;

    void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    double interest = 500;

    void showInterest() {
        System.out.println("Interest: " + interest);
    }
}

public class Inheritance8 {
    public static void main(String[] args) {

        SavingsAccount s = new SavingsAccount();

        s.showBalance();
        s.showInterest();
    }
}