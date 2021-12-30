package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        double vnd = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD: ");
        double usd = scanner.nextDouble();

        vnd *= usd;

        System.out.printf("%f USD = %f VNĐ", usd, vnd);
    }
}
