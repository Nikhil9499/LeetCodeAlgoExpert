package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
	public static void main(String[] args) {
		printArray(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10));
		printArray(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 20));
		printArray(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, -5));
	}

	public static int[] twoNumberSum(int[] array, int targetSum) {
		int[] ans = new int[2];
		Set<Integer> map = new HashSet<>();

		for (int i=0; i<array.length; i++) {
			int first = targetSum - array[i];
			if (map.contains(first)) {
				ans[0] = array[i];
				ans[1] = first;
				return ans;
			} else {
				map.add(array[i]);
			}
		}

		return new int[0];
	}

	public static void printArray(int[]arr) {
		Arrays.stream(arr)
			.forEach(ele -> System.out.print(ele + " "));
		System.out.println();
	}

}
