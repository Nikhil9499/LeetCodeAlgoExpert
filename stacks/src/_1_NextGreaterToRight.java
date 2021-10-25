import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _1_NextGreaterToRight {
	public static void main(String[] args) {
		int[] arr = {4, 3, 5, 4, 6, 7, 2, 9};
		System.out.println(nextGreaterToRight(arr));
	}

	public static List<Integer> nextGreaterToRight(int[] arr) {
		List<Integer> ans = new ArrayList<>();

		if (arr == null || arr.length == 0) {
			return ans;
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			int current = arr[i];

			while (!stack.isEmpty() && stack.peek() < current) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				ans.add(-1);
			} else {
				ans.add(stack.peek());
			}

			stack.add(current);
		}

		Collections.reverse(ans);
		return ans;
	}
}
