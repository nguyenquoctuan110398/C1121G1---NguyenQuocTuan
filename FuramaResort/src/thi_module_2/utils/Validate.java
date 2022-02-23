package thi_module_2.utils;

import java.util.Scanner;

public class Validate {
    static Scanner scanner = new Scanner(System.in);

    public static String regex (String temp, String regex, String error){
        boolean check=true;
        do {
            if(temp.matches(regex)){
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        }while (check);
        return temp;
    }
}
