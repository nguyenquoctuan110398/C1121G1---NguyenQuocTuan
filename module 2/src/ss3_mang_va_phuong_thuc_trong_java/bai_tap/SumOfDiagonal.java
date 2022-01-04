package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column: ");
        int m = scanner.nextInt();
        int sum = 0;

        int[][] arr = new int[m][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
//                System.out.println("Enter element " + i + "-" + j + ": ");
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Sum is: " + sum);
    }
}
