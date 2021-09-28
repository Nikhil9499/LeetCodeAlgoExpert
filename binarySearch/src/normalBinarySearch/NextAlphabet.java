package normalBinarySearch;

public class NextAlphabet {
	public static void main(String[] args) {
		char[]arr = {'b', 'f','g', 'l'};
		System.out.println(nextAlphabet(arr, 'c'));
		System.out.println(nextAlphabet(arr, 'a'));
		System.out.println(nextAlphabet(arr, 'l'));
		System.out.println(nextAlphabet(arr, 'g'));
	}

	public static char nextAlphabet(char[]arr, char k) {
		int low =0, high = arr.length-1;
		int index = -1;

		while(low <= high) {
			int mid = low + (high-low)/2;

			if(arr[mid] == k) {
				index = mid;
				break;
			} else if (arr[mid] < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		if (index != -1) {
			if (index != arr.length-1)
				return arr[index+1];
			else
				return '0';
		} else {
			return arr[low];
		}
	}
}
