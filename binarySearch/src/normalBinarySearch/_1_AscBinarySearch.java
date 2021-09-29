package normalBinarySearch;

public class _1_AscBinarySearch {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(binarySearchAsc(arr, 3));
		System.out.println(binarySearchAsc(arr, 7));
		System.out.println(binarySearchAsc(arr, 0));

		System.out.println(binarySearchAscRecursive(arr, 0, arr.length, 3));
		System.out.println(binarySearchAscRecursive(arr, 0, arr.length, 7));
		System.out.println(binarySearchAscRecursive(arr, 0, arr.length, 0));
	}

	public static int binarySearchAsc(int[]arr, int target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low)/2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearchAscRecursive(int[]arr, int low, int high, int target) {
		if(low > high) {
			return -1;
		}

		int mid = low + (high-low)/2;

		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] > target) {
			return binarySearchAscRecursive(arr, low, mid-1, target);
		} else {
			return binarySearchAscRecursive(arr, mid+1, high, target);
		}
	}
}
