package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class FindMaxInArray2d {
    public static void main(String[] args) {
        int max;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int m = scanner.nextInt();
        System.out.println("Enter column: ");
        int n = scanner.nextInt();

        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
//                System.out.println("Enter element " + i + "-" + j + ": ");
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Max in array is: " + max);
    }
}
