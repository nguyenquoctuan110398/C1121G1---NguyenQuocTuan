package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int m = scanner.nextInt();
        System.out.println("Enter column: ");
        int n = scanner.nextInt();

        int[][] arr = new int[m][n];
        for (
                int i = 0;
                i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
//                System.out.println("Enter element " + i + "-" + j + ": ");
                arr[i][j] = (int) (Math.random() * 100);
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("Enter the column to sum: ");
        int column1 = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i][column1];
        }
        System.out.println("Sum: " + sum);
    }

}
