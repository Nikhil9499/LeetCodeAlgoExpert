package normalBinarySearch;

public class _3_CountOccurrences {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 2, 2, 2, 3, 4, 5, 6};
		System.out.println(countOccurrences(arr, 2));
		System.out.println(countOccurrences(arr, 6));
		System.out.println(countOccurrences(arr, 0));
	}

	public static int countOccurrences(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int minIndex = findMinIndex(arr, target);
		int maxIndex = findMaxIndex(arr, 0, arr.length - 1, target, new Res(-1));

		if (minIndex == maxIndex && minIndex == -1) {
			return 0;
		}

		return maxIndex - minIndex + 1;
	}

	public static int findMinIndex(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		int minIndex = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				minIndex = mid;
				high = mid - 1;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return minIndex;
	}

	public static int findMaxIndex(int[] arr, int low, int high, int target, Res res) {
		if (low > high) {
			return res.res;
		}

		int mid = low + (high - low) / 2;

		if (arr[mid] == target) {
			res.res = mid;
			return findMaxIndex(arr, mid + 1, high, target, res);
		} else if (arr[mid] > target) {
			return findMaxIndex(arr, low, mid - 1, target, res);
		} else {
			return findMaxIndex(arr, mid + 1, high, target, res);
		}
	}

	static class Res {
		int res;

		public Res(int res) {
			this.res = res;
		}
	}
}
