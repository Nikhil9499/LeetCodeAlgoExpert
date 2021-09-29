package normalBinarySearch;/*
	Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions
	, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
	Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
*/

public class _8_SearchingInNearlySortedArray {
	public static void main(String[] args) {
		int arr[] = {3, 2, 10, 4, 40};
		System.out.println(searchInNearlySortedArray(arr, 4));
		System.out.println(searchInNearlySortedArray(arr, 40));
		System.out.println(searchInNearlySortedArray(arr, 3));
		System.out.println(searchInNearlySortedArray(arr, 0));
	}

	public static int searchInNearlySortedArray(int[]arr, int target) {
		int low = 0, high = arr.length-1;

		while (low <= high) {
			int mid = low + (high-low)/2;

			if(arr[mid] == target) {
				return mid;
			} else if (mid > 0 && arr[mid-1] == target) {
				return mid-1;
			} else if (mid < arr.length-1 && arr[mid+1] == target) {
				return mid+1;
			} else if (arr[mid] < target) {
				low = mid + 2;
			} else {
				high = mid - 2;
			}
		}

		return -1;
	}
}
