package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int number = scanner.nextInt();

        if (number < 2) {
            System.out.printf("%d is not prime number", number);
        } else {
            boolean check = true;
            int i = 2;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.printf("%d is prime number", number);
            } else {
                System.out.printf("%d isn't prime number", number);
            }
        }

    }
}
