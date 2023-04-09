import java.util.Scanner;
import java.util.Stack;

class _15_RemoveNDigitsToMakeSmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            System.out.println(removeKdigits(S, K));
        }
    }


    public static String removeKdigits(String s, int k) {
        if (k <= 0) {
            return s;
        }

        if (s == null || s.length() <= k) {
            return "0";
        }

        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            if (!stack.isEmpty() || ch != '0') {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }

    }
}