/*
consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible rectangle possible is 12
*/

import java.util.Stack;

public class _6_MaxAreaHistogram {
	public static void main(String[] args) {
		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(maxHistogramArea(arr, arr.length));
		int[] arr1 = {5, 4, 3, 2, 1};
		System.out.println(maxHistogramArea(arr1, arr1.length));
		int[] arr2 = {9, 10, 4, 10, 4, 5, 16};
		System.out.println(maxHistogramArea(arr2, arr2.length));
	}

	public static int maxHistogramArea(int[] arr, int n) {
		int[] nextSmallerToLeft = nextSmallerToLeftIndices(arr, n);
		int[] nextSmallerToRight = nextSmallerToRightIndices(arr, n);

		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int width = nextSmallerToRight[i] - nextSmallerToLeft[i] - 1;
			maxArea = Math.max(maxArea, width * arr[i]);
		}

		return maxArea;
	}

	public static int[] nextSmallerToLeftIndices(int[] arr, int n) {
		int[] leftIndices = new int[n];
		leftIndices[0] = -1;

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(arr[0], 0));

		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && stack.peek().getA() >= arr[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				leftIndices[i] = -1;
			} else {
				leftIndices[i] = stack.peek().getB();
			}
			stack.push(new Pair(arr[i], i));
		}

		return leftIndices;
	}

	public static int[] nextSmallerToRightIndices(int[] arr, int n) {
		int[] rightIndices = new int[n];
		rightIndices[n - 1] = n;

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(arr[n - 1], n - 1));

		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek().getA() >= arr[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				rightIndices[i] = n;
			} else {
				rightIndices[i] = stack.peek().getB();
			}
			stack.push(new Pair(arr[i], i));
		}

		return rightIndices;
	}
}
