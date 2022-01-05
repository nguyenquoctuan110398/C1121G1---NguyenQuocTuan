package file_giai_thuat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SapXepMang {
    public static void main(String[] args) {
        int[] arrA = {7, 2, 5, 3, 5, 3};
        int[] arrB = {7, 6, 5, 4, 4, 6, 5, 3};
        int[] arrC = new int[arrB.length];
        System.out.println(arrC.length);

        int index = 0;

        for (int i = 0; i < arrB.length; i++) {
            boolean check = true;
            for (int j = 0; j < arrA.length; j++) {
                if (arrB[i] == arrA[j]) {
                    check = false;
                    break;
                }
//        System.out.println(Arrays.toString(arrC));
            }
            if (check) {
                for (int j = 0; j < arrC.length; j++) {
                    if (arrB[i] == arrC[j]) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                arrC[index] = arrB[i];
                index++;
            }

        }
        System.out.println(index);
        System.out.println(Arrays.toString(arrC));

        int[] arrD = new int[index];
        for (int i = 0; i < arrD.length; i++) {
            arrD[i] = arrC[i];
        }

        int temp;
        for (int i = 0; i < arrD.length - 1; i++) {
            for (int j = i + 1; j < arrD.length; j++) {
                if (arrD[i] > arrD[j]) {
                    temp = arrD[i];
                    arrD[i] = arrD[j];
                    arrD[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arrD));
    }
}
