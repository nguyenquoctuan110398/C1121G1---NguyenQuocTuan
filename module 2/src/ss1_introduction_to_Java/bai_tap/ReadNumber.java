package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to read: ");

        int number = scanner.nextInt();
        String string = scanner.nextLine();

        int ones = number % 10;
        int tens = number % 100 / 10;
        int hundreds = number / 100;

        if (number >= 0 && number < 10) {
            System.out.printf("%s", readOnes(ones));
        }

        if (number >= 10 && number < 20) {
            System.out.printf("%s", readSpecialNumber(number));
        }

        if (number >= 20 && number < 100) {
            if (ones != 0) {
                System.out.printf("%s %s", readTens(tens) + readOnes(ones));
            } else
//            string = readTens(tens) + readOnes(ones);
                System.out.printf("%s", readTens(tens));
        }

        if (number >= 100) {
            int check = number % 100;
//            System.out.println(tens);
//            System.out.println(ones);
            if (check > 10 && check < 20) {
                System.out.printf("%s hundred and %s", readOnes(hundreds), readSpecialNumber(check));
            } else if (ones != 0) {
                System.out.printf("%s hundred and %s%s", readOnes(hundreds), readTens(tens), readOnes(ones));
//            string = readOnes(hundreds) + " hundred and " + readTens(tens) + readOnes(ones);
            } else if (tens != 0) {
                System.out.printf("%s hundred and %s", readOnes(hundreds), readTens(tens));
//                string = readOnes(hundreds) + " hundred and " + readTens(tens);
            } else {
                System.out.printf("%s hundred", readOnes(hundreds));
//                string = readOnes(hundreds) + " hundred";
            }
            System.out.println(string);
        }

    }

    public static String readSpecialNumber(int number) {
        String string = "";
        int ones = number % 10;
        switch (ones) {
            case 0:
                string += "ten";
            case 1:
                string += "eleven";
                break;
            case 2:
                string += "twelve";
                break;
            case 3:
                string += "thirteen";
                break;
            case 5:
                string += "fifteen";
                break;
            case 8:
                string += "eighteen";
                break;
            default:
                string += readOnes(ones) + "teen";
                break;

        }
        return string;
    }

    public static String readTens(int number) {
        String string = "";
        switch (number) {
            case 2:
                string += "twenty ";
                break;
            case 3:
                string += "thirty ";
                break;
            case 4:
                string += "forty ";
                break;
            case 5:
                string += "fifty ";
                break;
            case 8:
                string += readOnes(number) + "y ";
                break;
            default:
                string += readOnes(number) + "ty ";
                break;
        }
        return string;
    }

    public static String readOnes(int number) {

        String string = "";
        switch (number) {
            case 0:
                string += "zero";
                break;

            case 1: {
                string += "one";
                break;
            }
            case 2: {
                string += "two";
                break;
            }
            case 3: {
                string += "three";
                break;
            }
            case 4: {
                string += "four";
                break;
            }
            case 5: {
                string += "five";
                break;
            }
            case 6: {
                string += "six";
                break;
            }
            case 7: {
                string += "seven";
                break;
            }
            case 8: {
                string += "eight";
                break;
            }
            case 9: {
                string += "nine";
                break;
            }
        }
        return string;
    }
}

