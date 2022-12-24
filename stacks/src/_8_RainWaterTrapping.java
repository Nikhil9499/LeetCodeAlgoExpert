public class _8_RainWaterTrapping {
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(rainTrapped(arr));
		System.out.println(rainTrapped2(arr, arr.length));
	}

	public static int rainTrapped(int[] arr) {
		int n = arr.length;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}

		rightMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}

		int rainTrapped = 0;
		for (int i = 0; i < n; i++) {
			int minHt = Math.min(leftMax[i], rightMax[i]);
			rainTrapped += (minHt - arr[i]);
		}
		return rainTrapped;
	}

	static int rainTrapped2(int[] arr, int n)
	{

		// Indices to traverse the array
		int left = 0;
		int right = n - 1;

		// To store Left max and right max
		// for two pointers left and right
		int l_max = 0;
		int r_max = 0;

		// To store the total amount
		// of rain water trapped
		int result = 0;
		while (left <= right) {

			// We need check for minimum of left
			// and right max for each element
			if (r_max <= l_max) {

				// Add the difference between
				// current value and right max at index r
				result += Math.max(0, r_max - arr[right]);

				// Update right max
				r_max = Math.max(r_max, arr[right]);

				// Update right pointer
				right -= 1;
			}
			else {

				// Add the difference between
				// current value and left max at index l
				result += Math.max(0, l_max - arr[left]);

				// Update left max
				l_max = Math.max(l_max, arr[left]);

				// Update left pointer
				left += 1;
			}
		}
		return result;
	}


}
