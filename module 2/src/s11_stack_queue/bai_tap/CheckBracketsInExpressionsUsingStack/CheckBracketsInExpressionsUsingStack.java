package s11_stack_queue.bai_tap.CheckBracketsInExpressionsUsingStack;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracketsInExpressionsUsingStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String string = scanner.nextLine();
//        string = string.toLowerCase();
        int size = string.length();
        boolean check = true;
        Character left;

        Stack<Character> bStack = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (string.charAt(i) == '(') {
                bStack.push(string.charAt(i));
                System.out.println(bStack);
            }
            if (string.charAt(i) == ')') {
                if (bStack.isEmpty()) {
                    check = false;
                    break;
                }
                left = bStack.pop();
                System.out.println("a" + left);
                System.out.println("b"+string.charAt(i));
                if (left == string.charAt(i)) {
                    check = false;
                    break;
                }
            }
        }

        if (check) {
            System.out.println("Well");
        } else {
            System.out.println("???");
        }
    }
}
