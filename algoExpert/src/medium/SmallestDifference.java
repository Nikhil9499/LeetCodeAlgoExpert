package medium;

// Find the pair with the smallest difference in two unsorted arrays

import java.util.Arrays;

public class SmallestDifference {
	public static void main(String[] args) {
		int[] a1 = new int[] {-1, 5, 10, 20, 28, 3};
		int[] a2 = new int[] {26, 134, 135, 15, 17};

		int[] pair = smallestDifference(a1, a2);
		System.out.println(pair[0] + " " + pair[1]);


		pair = smallestDifferenceSorting(a1, a2);
		System.out.println(pair[0] + " " + pair[1]);
	}

	// O(n^2)
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		int[] ans = new int[2];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arrayOne.length; i++) {
			for (int j = 0; j < arrayTwo.length; j++) {
				int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
				if (min > diff) {
					min = diff;
					ans[0] = arrayOne[i];
					ans[1] = arrayTwo[j];
				}
			}
		}

		return ans;
	}

	// O(mlog(m) + nlog(n)) time and space: O(n)
	public static int[] smallestDifferenceSorting(int[] arrayOne, int[] arrayTwo) {

		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);

		int i = 0, j = 0;
		int current = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
		int[] ans = new int[2];

		while (i < arrayOne.length && j < arrayTwo.length) {
			int first = arrayOne[i], second = arrayTwo[j];
			if (first > second) {
				current = first - second;
				j++;
			} else if (first < second) {
				current = second - first;
				i++;
			} else {
				return new int[] {first, second};
			}

			if (current < min) {
				min = current;
				ans = new int[] {first, second};
			}
		}

		return ans;
	}
}
