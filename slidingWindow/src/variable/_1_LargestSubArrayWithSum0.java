package variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1_LargestSubArrayWithSum0 {
	public static void main(String[] args) {
		int[] arr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
		int sum = 10;
		System.out.println(lengthLargestSubArrayWithSum0(arr, sum));
		System.out.println(largestSubArrayWithSum0(arr, sum));
		System.out.println(countSubArrayWithSum0(arr, sum));
	}

	public static int lengthLargestSubArrayWithSum0(int[] arr, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(sum, -1);

		int j = 0, n = arr.length;
		int maxLen = 0;
		int currSum = 0;

		while (j < n) {
			currSum += arr[j];
			if (map.containsKey(currSum)) {
				maxLen = Math.max(maxLen, j - map.get(currSum));
			} else {
				map.put(currSum, j);
			}
			j++;
		}

		return maxLen;
	}

	public static List<Integer> largestSubArrayWithSum0(int[] arr, int sum) {
		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(sum, -1);

		int j = 0, n = arr.length;
		int maxLen = 0;
		int currSum = 0;
		int start = -1, end = -1;

		while (j < n) {
			currSum += arr[j];
			if (map.containsKey(currSum)) {
				if (maxLen < j - map.get(currSum)) {
					start = map.get(currSum) + 1;
					end = j;
				}
			} else {
				map.put(currSum, j);
			}
			j++;
		}

		ans.add(start);
		ans.add(end);
		return ans;
	}

	public static int countSubArrayWithSum0(int[] arr, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		// map of sum vs sum's count
		map.put(sum, 1);

		int j = 0, n = arr.length;
		int count = 0;
		int currSum = 0;

		while (j < n) {
			currSum += arr[j];
			if (map.containsKey(currSum)) {
				count += map.get(currSum);
				map.put(currSum, map.get(currSum) + 1);
			} else {
				map.put(currSum, 1);
			}
			j++;
		}

		return count;
	}

}
