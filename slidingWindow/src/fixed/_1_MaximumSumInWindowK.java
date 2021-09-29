package fixed;

import java.util.List;

public class _1_MaximumSumInWindowK {
	public static void main(String[] args) {
		int arr[] = {100, 200, 300, 100};
		int k = 2;
		System.out.println(maxSumInWindowK(arr, k));
	}

	public static int maxSumInWindowK(int[]arr, int k) {
		int ans = 0;

		if (arr == null || arr.length == 0 || k == 0){
			return ans;
		}

		int i=0, j=0, size=arr.length;
		int sum = 0;
		while (j < size){
			sum += arr[j];

			if (j-i+1 < k){
				j++;
			} else if (j-i+1 == k){
				ans = Math.max(ans, sum);
				sum -= arr[i];
				i++;
				j++;
			}
		}

		return ans;
	}
}
