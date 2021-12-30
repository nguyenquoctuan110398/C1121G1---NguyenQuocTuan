package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        double VND = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD: ");
        double USD = scanner.nextDouble();

        VND *= USD;

        System.out.printf("%f USD = %f VNĐ", USD, VND);
    }
}
