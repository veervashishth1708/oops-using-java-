import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("check Armstrong number");
        int num, original, remainder;
        int result = 0;

        System.out.print("Enter Number: ");
        num = sc.nextInt();

        original = num;

        while(original != 0) {
            remainder = original % 10;
            result += remainder * remainder * remainder;
            original /= 10;
        }

        if(result == num)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong Number");
    }
}