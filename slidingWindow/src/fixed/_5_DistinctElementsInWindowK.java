package fixed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _5_DistinctElementsInWindowK {
	public static void main(String[] args) {
		int arr[] = {2, 5, 5, 6, 3, 2, 3, 2, 4, 5, 2, 2, 2, 2, 3, 6};
		int k = 4;
		System.out.println(distinctElementsInWindowK(arr, k));
	}

	public static List<Integer> distinctElementsInWindowK(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> freqMap = new HashMap<>();

		int i = 0, j = 0, n = arr.length;
		while (j < n) {
			freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0) + 1);
			if (j - i + 1 == k) {
				ans.add(getCountAllDistinctInWindowK(freqMap));
				freqMap.put(arr[i], freqMap.get(arr[i]) - 1);
				if (freqMap.get(arr[i]) == 0) {
					freqMap.remove(arr[i]);
				}
				i++;
			}
			j++;
		}

		return ans;
	}

	private static int getCountAllDistinctInWindowK(Map<Integer, Integer> freqMap) {
		return freqMap.keySet().size();
	}
}
