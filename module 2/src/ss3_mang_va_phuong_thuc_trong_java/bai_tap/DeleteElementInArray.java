package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        int[] n = {10, 4, 6, 6, 8, 6, 0, 7, 0, 9};
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Value: ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + "  ");
        }
        System.out.println("");

        System.out.printf("Enter the value to delete: ");
        int x = scanner.nextInt();
        int indexDel;
        for (int i = 0; i < n.length; i++) {
            if (x == n[i]) {
                indexDel = i;
                for (int j = indexDel; j < n.length - 1; j++) {
                    n[j] = n[j + 1];
                }
                n[n.length - 1] = 0;
                i--;
//                break;
            }
        }

        System.out.print("New value: ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + "   ");
        }

    }
}
