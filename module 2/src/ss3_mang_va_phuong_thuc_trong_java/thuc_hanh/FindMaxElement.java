package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        int size;
        int arr[];
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20!");
            }
        } while (size > 20);

        int i = 0;
        arr = new int[size];
        while (i < arr.length) {
            System.out.print("Enter element " + (i + 1) + " : ");
            arr[i] = scanner.nextInt();
            i++;
        }

        System.out.print("Property list: ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "   ");
        }
        System.out.println();

        int max = arr[0];
        int index = 0;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
