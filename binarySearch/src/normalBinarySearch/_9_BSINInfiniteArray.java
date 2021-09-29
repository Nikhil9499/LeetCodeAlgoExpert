package normalBinarySearch;

public class _9_BSINInfiniteArray {
	public static void main(String[] args) {
		//infinite array
		int[]arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		System.out.println(findInInfiniteArray(arr, 8));
		System.out.println(findInInfiniteArray(arr, 11));
		System.out.println(findInInfiniteArray(arr, 0));
	}

	public static int findInInfiniteArray(int[]arr, int target) {
		int low=0,high=1;

		while(arr[high] < target) {
			low = high;
			high *= 2;
		}

		while(low <= high) {
			int mid = low + (high-low)/2;
			if(arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}
