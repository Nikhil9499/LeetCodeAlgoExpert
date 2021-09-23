import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallerToLeft {
	public static void main(String[] args) {
		int[]arr = {4,3,5,4,6,7,2,9};
		System.out.println(nextSmallerToLeft(arr));
	}

	public static List<Integer> nextSmallerToLeft(int[]arr) {
		List<Integer> ans = new ArrayList<>();

		if (arr == null || arr.length ==0) {
			return ans;
		}

		Stack<Integer> stack = new Stack<>();

		for (int i=0; i<arr.length; i++) {
			int current = arr[i];

			while(!stack.isEmpty() && stack.peek() > current) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				ans.add(-1);
			} else {
				ans.add(stack.peek());
			}

			stack.push(current);
		}

		return ans;
	}
}
