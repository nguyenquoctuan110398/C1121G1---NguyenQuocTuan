package ss3_mang_va_phuong_thuc_trong_java.bai_tap;


import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[(arr1.length + arr2.length)];

        int i = 0;
        int j = 0;
        Scanner scanner = new Scanner(System.in);

        while (i < arr1.length) {
            System.out.print("Enter element " + (i + 1) + " is: ");
            arr1[i] = scanner.nextInt();
            i++;
        }

        System.out.println("Array 1 is: "+Arrays.toString(arr1));

        while (j < arr2.length) {
            System.out.print("Enter element " + (j + 1) + " is: ");
            arr2[j] = scanner.nextInt();
            j++;
        }

        System.out.println("Array 2 is: " + Arrays.toString(arr2));

        System.out.print("Array 3 is: ");
        for (int z = 0; z < arr1.length; z++) {
            arr3[z] = arr1[z];

        }

        for (int z = arr1.length; z < arr3.length; z++) {
            arr3[(z)] = arr2[z- arr1.length];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
