package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class InsertElementArray {
    public static void main(String[] args) {
        int[] n = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Value: ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + "  ");
        }
        System.out.println();

        System.out.print("Enter the value to insert: ");
        int x = scanner.nextInt();
        System.out.println();
        System.out.print("Enter index to insert: ");
        int index = scanner.nextInt();

        if (index <= -1 || index >= n.length - 1) {
            System.out.println("Can not insert into array!");
        } else {
            for (int i = n.length - 1; i > index; i--) {
                n[i] = n[i - 1];
            }
            n[index] = x;
        }

        System.out.print("New value: ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + "  ");
        }
    }
}
