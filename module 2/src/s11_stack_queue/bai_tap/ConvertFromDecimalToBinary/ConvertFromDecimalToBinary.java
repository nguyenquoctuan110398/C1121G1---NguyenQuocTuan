package s11_stack_queue.bai_tap.ConvertFromDecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class ConvertFromDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = Integer.parseInt(scanner.nextLine());
        int tempNumber=Math.abs(number);

        while (tempNumber / 2 != 0) {
            stack.push(tempNumber % 2);
            tempNumber /= 2;
        }
        stack.push(tempNumber);
        if(number<0){
            stack.push(1);
        }
        System.out.println(stack);
        int size=stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}