import java.util.Scanner;

public class GiaiThuat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        String str = "";

        do {
            n = Integer.parseInt(scanner.nextLine());
        } while (!((n % 2) == 0));

        for (int i = 1; i < n; i++) {
            if (i <= (n / 2)) {
                for (int j = i; j <= n - i; j++) {

                    System.out.print("*");


                }
            }
            System.out.println();
        }
    }

}
