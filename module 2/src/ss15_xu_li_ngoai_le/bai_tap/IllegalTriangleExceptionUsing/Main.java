package ss15_xu_li_ngoai_le.bai_tap.IllegalTriangleExceptionUsing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        int[] arr = new int[3];
        while (flag) {
            flag = false;
            try {
                arr = inputTriangleEdge();
            } catch (IllegalTriangleException e) {
                e.getStackTrace();
                flag = true;
                System.out.println("Re-enter the value: ");
            } catch (Exception e) {
                flag = true;
                System.out.println("Lỗi khác");
            }
        }

        String str="";

        for (int i = 0; i < arr.length; i++){
            str+=arr[i] + " ";
        }
        str += "là 3 cạnh của tam giác";
        System.out.println(str);
    }

    public static int[] inputTriangleEdge() throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        int[] arrTriangleEdge = new int[3];
        for (int i = 0; i < arrTriangleEdge.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arrTriangleEdge[i] = Integer.parseInt(scanner.nextLine());
        }

        if (arrTriangleEdge[0] <= 0 || arrTriangleEdge[1] <= 0 || arrTriangleEdge[1] <= 0 ||
                (arrTriangleEdge[0] + arrTriangleEdge[1]) <= arrTriangleEdge[2] ||
                (arrTriangleEdge[1] + arrTriangleEdge[2]) <= arrTriangleEdge[0] ||
                (arrTriangleEdge[0] + arrTriangleEdge[2]) <= arrTriangleEdge[1]) {
            throw new IllegalTriangleException("Not 3 sides of a triangle");
        }
        return arrTriangleEdge;
    }
}
