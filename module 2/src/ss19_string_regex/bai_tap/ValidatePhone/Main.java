package ss19_string_regex.bai_tap.ValidatePhone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String regex = "^\\(\\d{2}\\)\\-\\(0\\d{9}\\)$";

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        boolean check = phoneNumber.matches(regex);

        if(check){
            System.out.println("Valid phone number: " + phoneNumber);
        }else {
            System.out.println("Invalid phone number: " + phoneNumber);
        }
    }
}
