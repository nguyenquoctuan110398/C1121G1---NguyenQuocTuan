package ss15_xu_li_ngoai_le.thuc_hanh.ArrayIndexOutOfBoundsExceptionUsing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayExample arrayExample= new ArrayExample();
        Integer [] arr = arrayExample.createRandom();

        Scanner scanner=new Scanner(System.in);
        System.out.println("\nEnter the index of any element: ");
        int index =scanner.nextInt();
        try{
            System.out.println("The value of the element with index " + index + " is: " + arr[index]);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index exceeds the limit of the array");
        }
    }
}
