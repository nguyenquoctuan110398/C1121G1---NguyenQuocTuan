package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class DisplayGeometry {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter height: ");
                    int height = scanner.nextInt();
                    System.out.println("Enter weight: ");
                    int weight = scanner.nextInt();

                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < weight; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    int choice1 = -1;
                    System.out.println("Nhập height: ");
                    int h = scanner.nextInt();
                    while (choice1 != 0) {
                        System.out.println("Enter right triangle angle:");
                        System.out.println("1. Top-left");
                        System.out.println("2. Top-right");
                        System.out.println("3. Botton-left");
                        System.out.println("4. Botton-right");
                        System.out.println("0. Exit");
                        System.out.println("Enter your choice:");
                        choice1 = scanner.nextInt();

                        switch (choice1) {
                            case 1:
                                for (int i = 0; i < h; i++) {
                                    for (int j = 0; j < h - i; j++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 2:
                                for (int i = 0; i < h; i++) {
                                    for (int j = 0; j <= i; j++) {
                                        System.out.print(" ");
                                    }
                                    for (int z = i; z < h; z++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 3:
                                for (int i = 0; i < h; i++) {
                                    for (int j = 0; j <= i; j++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 4:
                                for (int i = 0; i < h; i++) {
                                    for (int j = 0; j < h - i; j++) {
                                        System.out.print(" ");
                                    }
                                    for (int z = 0; z <= i; z++) {
                                        System.out.print("*");
                                    }
                                    System.out.println();
                                }
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Nhập height: ");
                    int h1 = scanner.nextInt();
                    for (int i = 0; i < h1; i++) {
                        for (int j = 0; j < 2 * h1; j++) {
                            if (Math.abs(j - h1) <= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }
        }
    }
}
