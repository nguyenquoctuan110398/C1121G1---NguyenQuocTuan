package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        int size;
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter size: ");
            size = Integer.parseInt((scanner.nextLine()));
        } while (!(size > 0));


        int[] arr = new int[size];

        while (i < size) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = Integer.parseInt(scanner.nextLine());
            i++;
        }

        int min = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
            }
        }
        System.out.println("Min element in array is: " + min);
    }
}
