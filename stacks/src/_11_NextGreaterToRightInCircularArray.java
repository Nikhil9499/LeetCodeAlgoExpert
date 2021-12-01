import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class _11_NextGreaterToRightInCircularArray {

//	Input: nums = [1,2,3,4,3]
//	Output: [2,3,4,-1,4]
	public static void main(String[] args) {
		int[]arr = {1,2,3,4,3};
		System.out.println(nextGreaterElementCircularArray(arr));
		int[] ans = nextGreaterElements(arr);
		Arrays.stream(ans).forEach(value -> System.out.print(value+" "));
	}

	public static ArrayList<Integer> nextGreaterElementCircularArray(int[]arr) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;

		// preprocess(or fill) stack for all but last element
		for (int i=n-2; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			stack.push(arr[i]);
		}

		for (int i=n-1; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			ans.add(stack.isEmpty()?-1:stack.peek());
			stack.push(arr[i]);
		}

		Collections.reverse(ans);
		return ans;
	}

	public static int[] nextGreaterElements(int[] nums) {
		int[] res = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * nums.length - 1; i >= 0; --i) {
			while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
				stack.pop();
			}
			res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
			stack.push(i % nums.length);
		}
		return res;
	}

}
