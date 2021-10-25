package normalBinarySearch;

import java.util.ArrayList;
import java.util.List;

public class _4_FloorCeilOfNumber {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 6, 7, 9, 10, 14, 17};
		System.out.println(floorCeil(arr, 5));
		System.out.println(floorCeil(arr, 8));
		System.out.println(floorCeil(arr, 18));
		System.out.println(floorCeil(arr, -10));
	}

	public static List<Integer> floorCeil(int[] arr, int target) {
		List<Integer> ans = new ArrayList<>();

		int low = 0, high = arr.length - 1;
		int index = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				index = mid;
				break;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		if (index != -1) {
			ans.add(arr[index]);
			ans.add(arr[index]);
			return ans;
		} else {
			if (high >= 0)
				ans.add(arr[high]);
			else
				ans.add(Integer.MIN_VALUE);
			if (low <= arr.length - 1)
				ans.add(arr[low]);
			else
				ans.add(Integer.MAX_VALUE);
			return ans;
		}
	}
}
