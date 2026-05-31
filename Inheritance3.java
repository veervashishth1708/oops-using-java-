class Person {

    String name = "Veer";

    void displayName() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {

    int rollNo = 101;

    void displayRollNo() {
        System.out.println("Roll No: " + rollNo);
    }
}

public class Inheritance3 {
    public static void main(String[] args) {

        Student s = new Student();

        s.displayName();
        s.displayRollNo();
    }
}