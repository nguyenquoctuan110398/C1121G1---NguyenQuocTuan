package s11_stack_queue.bai_tap.ReverseElementUsingStack;

import java.util.Stack;

public class ReverseElement {
    public static void main(String[] args) {
        Stack<Integer> wStack = new Stack<>();
        Stack<Integer> wStack1 = new Stack<>();
        wStack.push(1);
        wStack.push(5);
        wStack.push(4);
        wStack.push(9);
        wStack.push(3);
        wStack.push(4);
        wStack.push(8);
        wStack.push(5);
        System.out.println("Fre-reverse:");
        System.out.println(wStack);

        int size=wStack.size();
        for (int i = 0; i < size; i++) {
            wStack1.push(wStack.pop());
        }
        System.out.println("After-reverse:");
        System.out.println(wStack1);
    }
}
