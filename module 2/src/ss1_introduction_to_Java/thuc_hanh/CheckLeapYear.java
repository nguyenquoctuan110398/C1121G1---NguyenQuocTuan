package ss1_introduction_to_Java.thuc_hanh;

import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.println("Enter year: ");
        year = scanner.nextInt();
//        if (year % 4 == 0) {
//            if (year % 100 != 0) {
//                System.out.println(year + " is leap year!");
//            } else if (year % 400 == 0) {
//                System.out.println(year + " is leap year!");
//            } else {
//                System.out.println(year + " isn't leap year!");
//            }
//        } else {
//            System.out.println(year + " isn't leap year!");
//        }

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.printf("%d is leap year! \n", year);
                } else {
                    System.out.printf("%d isn't leap year! \n", year);
                }
            } else {
                System.out.printf("%d is leap year! \n", year);
            }
        } else {
            System.out.printf("%d isn't leap year! \n", year);
        }

    }
}

//        boolean isLeapYear = false;
//
//        boolean isDivisibleBy4 = year % 4 == 0;
//        if(isDivisibleBy4){
//            boolean isDivisibleBy100 = year % 100 == 0;
//            if(isDivisibleBy100){
//                boolean isDivisibleBy400 = year % 400 == 0;
//                if(isDivisibleBy400){
//                    isLeapYear = true;
//                }
//            } else {
//                isLeapYear = true;
//            }
//        }
//
//        if(isLeapYear){
//            System.out.printf("%d is a leap year", year);
//        } else {
//            System.out.printf("%d is NOT a leap year", year);
//        }
//    }
//    }
