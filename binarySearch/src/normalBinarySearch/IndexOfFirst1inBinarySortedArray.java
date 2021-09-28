package normalBinarySearch;

public class IndexOfFirst1inBinarySortedArray {
	public static void main(String[] args) {
		//infinite array
		int[]arr = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(findIndexOfFirst1(arr));
	}

	public static int findIndexOfFirst1(int[]arr) {
		int low = 0, high = 1;

		while (arr[high] != 1) {
			low = high;
			high *= 2;
		}

		return findMinIndexRecursive(arr, low, high, 1, new CountOccurrences.Res(-1));
	}

	public static int findMinIndexRecursive(int[]arr, int low, int high, int target, CountOccurrences.Res res) {
		if (low > high) {
			return res.res;
		}

		int mid = low + (high - low)/2;

		if (arr[mid] == target) {
			res.res = mid;
			return findMinIndexRecursive(arr, low, mid-1, target, res);
		} else if (arr[mid] > target) {
			return findMinIndexRecursive(arr, low, mid-1, target, res);
		} else {
			return findMinIndexRecursive(arr, mid+1, high, target, res);
		}
	}
}
