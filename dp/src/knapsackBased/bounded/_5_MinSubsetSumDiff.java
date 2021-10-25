package knapsackBased.bounded;

import java.util.ArrayList;
import java.util.List;

public class _5_MinSubsetSumDiff {
	public static void main(String[] args) {
		int[] arr = {1, 6, 11, 5};
		System.out.println(minimumSubsetSumDiff(arr, arr.length));

		int[] arr1 = {3, 1, 4, 2, 2, 1};
		System.out.println(minimumSubsetSumDiff(arr1, arr1.length));
	}

	public static int minimumSubsetSumDiff(int[] arr, int n) {
		int sum = 0;
		for (int ele : arr) {
			sum += ele;
		}

		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				} else if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				}
			}
		}

		List<Integer> possibleSums = new ArrayList<>();
		for (int i = 0; i <= sum; i++) {
			if (dp[n][i]) {
				possibleSums.add(i);
			}
		}

		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < possibleSums.size() / 2; i++) {
			minDiff = Math.min(minDiff, sum - 2 * possibleSums.get(i));
		}

		return minDiff;
	}
}
