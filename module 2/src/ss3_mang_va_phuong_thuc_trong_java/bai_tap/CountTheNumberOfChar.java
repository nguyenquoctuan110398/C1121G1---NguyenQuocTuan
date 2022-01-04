package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class CountTheNumberOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "abcbaslkjdlkqoie";
        System.out.print("Enter character to be counted: ");
        char character = scanner.nextLine().charAt(0);
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }
        System.out.println("Number of character occurrences " + character + " in string is: " + count);
    }
}
