package s11_stack_queue.bai_tap.CheckingPalindromeStringsUsingQueue;

import java.util.*;

public class CheckingPalindromeStringsUsingQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String string = scanner.nextLine();
        string = string.toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        int length = string.length();
        int size = string.length();

        for (int i = 0; i < size; i++) {
            stack.push(string.charAt(i));
            queue.add(string.charAt(i));
        }
        System.out.println(stack);
        System.out.println(queue);

        boolean check = true;
        for (int i = 0; i < size; i++) {
            if (stack.pop() != queue.remove()) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not Palindrome");

        }
    }
}
