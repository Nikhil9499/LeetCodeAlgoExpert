package normalBinarySearch;

public class _6_NoOfTimesArrayIsSorted {
	public static void main(String[] args) {
		int[] arr = {4, 5, 1, 2, 3}; //4
		System.out.println(noOfTimesArrayIsRotated(arr));
	}

	public static int noOfTimesArrayIsRotated(int[] arr) {
		int low = 0, high = arr.length - 1;
		int ans = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			//System.out.println("mid: "+mid);

			if ((mid == arr.length - 1 || arr[mid] < arr[mid + 1]) && (mid == 0 || arr[mid] < arr[mid - 1])) {
				ans = mid;
				break;
			} else if (arr[low] < arr[mid]) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}

		return ans;
	}
}
