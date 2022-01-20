package ss15_xu_li_ngoai_le.thuc_hanh.ArrayIndexOutOfBoundsExceptionUsing;

import java.util.Random;

public class ArrayExample {
    public Integer[] createRandom(){
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List of array element: ");
        for (int i=0; i<100;i++){
            arr[i]= rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }
}
