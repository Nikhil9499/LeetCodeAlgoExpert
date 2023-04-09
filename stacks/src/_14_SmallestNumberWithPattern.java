import java.util.Stack;

// Can use only 1-9 numbers with no duplicates
// Form the smallest possible number following the pattern
// Eg:  d d d           i i i
//     4 3 2 1         1 2 3 4
// Approach: Split wrt i's and increase count
public class _14_SmallestNumberWithPattern {
    public static void main(String[] args) {
        String pattern = "ddd";
        smallestNumberFollowingPattern(pattern);

        pattern = "iii";
        smallestNumberFollowingPattern(pattern);

        pattern = "dididi";
        smallestNumberFollowingPattern(pattern);

        pattern = "dddiddd";
        smallestNumberFollowingPattern(pattern);
    }

    public static void smallestNumberFollowingPattern(String pattern) {
        if (pattern == null || pattern.length() > 8) {
            System.out.println("Invalid pattern " + pattern);
            return;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int n = pattern.length();

        for (int i=0; i<n; i++) {
            char ch = pattern.charAt(i);
            stack.push(num);
            num++;

            if (ch == 'i') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
            }
        }
        stack.push(num);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
