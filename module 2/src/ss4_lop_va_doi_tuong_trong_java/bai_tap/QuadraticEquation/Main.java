package ss4_lop_va_doi_tuong_trong_java.bai_tap.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.printf("Enter a, b, c: %d %d %d",a, b, c);
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        System.out.printf("Enter a, b, c: %f %f %f", a, b, c);

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double delta = quadraticEquation.getDiscriminant();

        if (delta > 0) {
            System.out.printf("\nThe equation has two roots %f and %f",
                    quadraticEquation.getRoot1(), quadraticEquation.getRoot2());
        } else if (delta == 0) {
            System.out.printf("\nThe equation has one root %f", quadraticEquation.getRoot1());
        } else {
            System.out.printf("\nThe equation has no real roots");
        }
    }
}
