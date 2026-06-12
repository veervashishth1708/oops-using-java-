class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

public class Sample1 extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }

    public static void main(String[] args) {
        Sample1 dog = new Sample1();

        dog.eat();
        dog.bark();
    }
}