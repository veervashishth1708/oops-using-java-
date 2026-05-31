class GrandFather {

    void house() {
        System.out.println("Grandfather owns a house");
    }
}

class Father extends GrandFather {

    void car() {
        System.out.println("Father owns a car");
    }
}

class Son extends Father {

    void bike() {
        System.out.println("Son owns a bike");
    }
}

public class Inheritance4 {
    public static void main(String[] args) {

        Son s = new Son();

        s.house();
        s.car();
        s.bike();
    }
}