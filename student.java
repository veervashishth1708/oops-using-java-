public class Student {
    String name;
    int rollNo;

    void display() {
        System.out.println(name);
        System.out.println(rollNo);
    }

    public static void main(String[] args) {
        Student s = new Student();

        s.name = "Veer";
        s.rollNo = 101;

        s.display();
    }
}