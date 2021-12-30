package ss1_introduction_to_Java.thuc_hanh;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight:");
        double weight = scanner.nextDouble();
        System.out.println("Enter height:");
        double height = scanner.nextDouble();

        double bmi = weight / Math.pow(height, 2);

        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18.5) {
            System.out.printf("%-20.5f%s", bmi, "Underweight");
        } else if (bmi < 25) {
            System.out.printf("%-20.5f%s", bmi, "Normal");
        } else if (bmi < 30) {
            System.out.printf("%-20.5f%s", bmi, "Overweight");
        } else System.out.printf("%-20.5f%s", bmi, "Obese");
    }
}
