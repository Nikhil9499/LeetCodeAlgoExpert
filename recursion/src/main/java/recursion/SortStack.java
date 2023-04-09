package recursion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (stack.size() != 10) {
            stack.push((int) (Math.random() * 10));
        }
        System.out.println("Original Stack: " + stack);

        sortStackInDecreasingOrder(stack);
        System.out.println("Decreasing order: " + stack + " & top is " + stack.peek());

        sortStackInIncreasingOrder(stack);
        System.out.println("Increasing order: " + stack + " & top is " + stack.peek());

    }

    public static void sortStackInDecreasingOrder(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int popElement = stack.pop();
        sortStackInDecreasingOrder(stack);
        insertAtCorrectIndexForDecreasingOrder(stack, popElement);
//        System.out.println(stack);
    }

    public static void insertAtCorrectIndexForDecreasingOrder(Stack<Integer> stack, int popElement) {
        if (stack.isEmpty()) {
            stack.push(popElement);
            return;
        }

        if (stack.peek() <= popElement) {
            stack.push(popElement);
        } else {
            int pop = stack.pop();
            insertAtCorrectIndexForDecreasingOrder(stack, popElement);
            stack.push(pop);
        }
    }

    public static void sortStackInIncreasingOrder(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int popElement = stack.pop();
        sortStackInIncreasingOrder(stack);
        insertAtCorrectIndexForIncreasingOrder(stack, popElement);
//        System.out.println(stack);
    }

    public static void insertAtCorrectIndexForIncreasingOrder(Stack<Integer> stack, int popElement) {
        if (stack.isEmpty()) {
            stack.push(popElement);
            return;
        }

        // Just change condition for order change
        if (stack.peek() >= popElement) {
            stack.push(popElement);
        } else {
            int pop = stack.pop();
            insertAtCorrectIndexForIncreasingOrder(stack, popElement);
            stack.push(pop);
        }
    }
}
