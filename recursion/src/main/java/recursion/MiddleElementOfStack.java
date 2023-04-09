package recursion;

import java.util.Stack;

public class MiddleElementOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int n = 6;
        while (stack.size() != n) {
            stack.push((int) (Math.random() * 10));
        }
        int midIdx = (int) Math.ceil(stack.size()/2.0);

        System.out.println("Original Stack: " + stack + ", Top is " + stack.peek() + " , Mid Index: "+midIdx);
        System.out.println(middleElementInStack(stack, midIdx));
    }

    public static int middleElementInStack(Stack<Integer> stack, int midIdx) {
        if (stack.isEmpty()) {
            return -1;
        }

        if (stack.size() == midIdx) {
            return stack.peek();
        }

        stack.pop();
        return middleElementInStack(stack, midIdx);
    }
}
