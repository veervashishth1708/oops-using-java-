class Display {

    void show(int num) {
        System.out.println("Integer: " + num);
    }

    void show(String text) {
        System.out.println("String: " + text);
    }
}

public class Overloading {
    public static void main(String[] args) {

        Display d = new Display();

        d.show(100);
        d.show("Veer");
    }
}