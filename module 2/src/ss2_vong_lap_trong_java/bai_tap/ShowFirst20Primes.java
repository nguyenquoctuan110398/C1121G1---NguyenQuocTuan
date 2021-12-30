package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class ShowFirst20Primes {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("");
//        int numbers =
        int count = 1;
        int n = 2;

        while (count <= 20) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }

            if(check){
                count++;
                System.out.print(n + ", ");

            }
            n++;
        }
    }
}
