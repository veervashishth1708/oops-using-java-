public class Train {
    String name;
    int trainNumber;
    String destination;

    void display() {
        System.out.println("Train Name: " + name);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Destination: " + destination);
    }

    public static void main(String[] args) {
        Train t = new Train();

        t.name = "Shatabdi Express";
        t.trainNumber = 12006;
        t.destination = "New Delhi";

        t.display();
    }
}