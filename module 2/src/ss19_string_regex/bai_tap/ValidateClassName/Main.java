package ss19_string_regex.bai_tap.ValidateClassName;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String regex = "^[CAP](\\d){4}[G-M]$";
        System.out.println("Enter classname: ");
        String className = scanner.nextLine();
        boolean check = className.matches(regex);
        if(check){
            System.out.println("Valid class name: " + className);
        }else {
            System.out.println("Invalid class name: " + className);
        }

    }
}
