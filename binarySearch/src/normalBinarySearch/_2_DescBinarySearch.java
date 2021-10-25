package normalBinarySearch;

public class _2_DescBinarySearch {
	public static void main(String[] args) {
		int[] arr = {7, 6, 5, 4, 3, 2, 1};
		System.out.println(binarySearchDesc(arr, 3));
		System.out.println(binarySearchDesc(arr, 7));
		System.out.println(binarySearchDesc(arr, 0));

		System.out.println(binarySearchDescRecursive(arr, 0, arr.length - 1, 3));
		System.out.println(binarySearchDescRecursive(arr, 0, arr.length - 1, 7));
		System.out.println(binarySearchDescRecursive(arr, 0, arr.length - 1, 0));

	}

	public static int binarySearchDesc(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static int binarySearchDescRecursive(int[] arr, int low, int high, int target) {
		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] > target) {
			return binarySearchDescRecursive(arr, mid + 1, high, target);
		} else {
			return binarySearchDescRecursive(arr, low, mid - 1, target);
		}
	}
}
