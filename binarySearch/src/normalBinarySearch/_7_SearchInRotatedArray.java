package normalBinarySearch;

public class _7_SearchInRotatedArray {
	public static void main(String[] args) {
		int[]arr = {4,5,6,7,8,1,2,3};
		System.out.println(twoPassSearch(arr, 5));
		System.out.println(twoPassSearch(arr, 3));
		System.out.println(twoPassSearch(arr, 4));
		System.out.println(twoPassSearch(arr, 0));

		System.out.println(singlePassSearch(arr, 5));
		System.out.println(singlePassSearch(arr, 3));
		System.out.println(singlePassSearch(arr, 4));
		System.out.println(singlePassSearch(arr, 0));

	}

	public static int twoPassSearch(int[]arr, int target) {
		int index = noOfTimesArrayIsRotated(arr);
		int left = binarySearch(arr, 0, index-1, target);
		int right = binarySearch(arr, index, arr.length-1, target);

		return left != -1 ? left : right;
	}

	public static int singlePassSearch(int[]arr, int target) {
		int low = 0, high = arr.length-1;

		while(low <= high) {
			int mid = low + (high-low)/2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[low] < arr[mid]) {
				if (target >= arr[low] && target<=arr[mid]) {
					high = mid;
				} else {
					low = mid+1;
				}
			} else {
				if (target >= arr[mid] && target<=arr[high]) {
					low = mid;
				} else {
					high = mid-1;
				}
			}
		}
		return -1;
	}

	public static int binarySearch(int[]arr, int low, int high, int target) {
		if(low > high) {
			return -1;
		}

		int mid = low + (high - low)/2;

		if(arr[mid] == target) {
			return mid;
		} else if (arr[mid] < target) {
			return binarySearch(arr, mid+1, high, target);
		} else {
			return binarySearch(arr, low, mid-1, target);
		}
	}

	public static int noOfTimesArrayIsRotated(int[]arr) {
		int low = 0, high = arr.length-1;

		while(low <= high) {
			int mid = low + (high - low)/2;
			if ((mid == 0 || arr[mid] < arr[mid-1]) && (mid == arr.length-1 || arr[mid] < arr[mid+1])) {
				return mid;
			} else if (arr[low] < arr[mid]) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
