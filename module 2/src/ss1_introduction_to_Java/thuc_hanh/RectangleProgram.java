package ss1_introduction_to_Java.thuc_hanh;

import java.util.Scanner;

public class RectangleProgram {
    public static void main(String[] args) {
        float height, width;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = scanner.nextFloat();

        System.out.println("Enter height: ");
        height = scanner.nextFloat();

        float area = height * width;
        System.out.println("Area is: " + area);
    }
}
