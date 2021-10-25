package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Find the pair with sum equal to given targetSum


public class TwoNumberSum {
	public static void main(String[] args) {
		System.out.println("O(n) approach with space O(n)");
		printArray(twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10));
		printArray(twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 20));
		printArray(twoNumberSum(new int[] {3, 5, -4, 8, 10, 1, -1, 6}, -5));

		System.out.println("NlogN approach with Two Pointers");
		printArray(twoNumberSumTwoPointers(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10));
		printArray(twoNumberSumTwoPointers(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 20));
		printArray(twoNumberSumTwoPointers(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, -5));
	}

	// O(n) || O(1)
	public static int[] twoNumberSum(int[] array, int targetSum) {
		int[] ans = new int[2];
		Set<Integer> map = new HashSet<>();

		for (int i = 0; i < array.length; i++) {
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

	// O(nlogn) || O(1)
	public static int[] twoNumberSumTwoPointers(int[] array, int targetSum) {
		Arrays.sort(array);

		int i = 0, j = array.length - 1;

		while (i < j) {
			int currentSum = array[i] + array[j];
			if (currentSum == targetSum) {
				return new int[] {array[i], array[j]};
			} else if (currentSum > targetSum) {
				j--;
			} else {
				i++;
			}
		}

		return new int[0];
	}

	public static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));
		System.out.println();
	}

}
