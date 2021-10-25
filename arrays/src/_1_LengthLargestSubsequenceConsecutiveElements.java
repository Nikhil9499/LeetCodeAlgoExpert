import java.util.HashMap;
import java.util.Map;

public class _1_LengthLargestSubsequenceConsecutiveElements {
	public static void main(String[] args) {
		int[] arr1 = {9, 2, 7, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0}; // 16 17 18 19
		int[] arr2 = {9, 7, 8, 6, 4, 5, 2, 3}; // all

		System.out.println(lenOfLargestSubsequenceWithConsecutiveElements(arr1));
		System.out.println(lenOfLargestSubsequenceWithConsecutiveElements(arr2));
	}

	public static int lenOfLargestSubsequenceWithConsecutiveElements(int[] arr) {
		int maxLen = 0;

		Map<Integer, Boolean> map = new HashMap<>();
		for (int val : arr) {
			map.put(val, true);
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i], false);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i])) {
				int tempLen = 1;
				while (map.containsKey(arr[i] + tempLen)) {
					tempLen++;
				}
				maxLen = Math.max(maxLen, tempLen);
			}
		}

		return maxLen;
	}
}
