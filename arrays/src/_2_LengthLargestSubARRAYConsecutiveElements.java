import java.util.HashSet;
import java.util.Set;

public class _2_LengthLargestSubARRAYConsecutiveElements {
	public static void main(String[] args) {
		int[] arr1 = {9, 2, 7, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0}; // 16 17 18 19
		int[] arr2 = {9, 7, 8, 6, 4, 5, 2, 3}; // all

		System.out.println(lenOfLargestSubARRAYWithConsecutiveElements(arr1));
		System.out.println(lenOfLargestSubARRAYWithConsecutiveElements(arr2));
	}

	public static int lenOfLargestSubARRAYWithConsecutiveElements(int[] arr) {
		// concept: max-min = j-i: for all distinct element
		int maxLen = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int max = arr[i];
			Set<Integer> set = new HashSet<>();
			set.add(arr[i]);

			for (int j = i + 1; j < arr.length; j++) {
				// to handle duplicate case
				if (set.contains(arr[j])) {
					break;
				}
				// add to test duplicate in next iteration
				set.add(arr[j]);

				// update min and max since one new element is introduced arr[j]
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);

				// then use the concept
				if (max - min == j - i) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
		}

		return maxLen;
	}
}
