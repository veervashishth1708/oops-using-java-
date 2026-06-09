public class pattern28 {

    public static void main(String[] args) {

        int n = 5;

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");

            for(char ch = 'A'; ch < 'A' + i; ch++)
                System.out.print(ch + " ");

            System.out.println();
        }
    }
}