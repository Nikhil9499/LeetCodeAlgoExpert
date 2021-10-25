package knapsackBased.bounded;

import java.util.Arrays;

public class _2_SubsetSum {
	public static void main(String args[]) {
		int set[] = {3, 1, 5, 9, 12};
		int sum = 10;
		int n = set.length;
		if (isSubsetSumRecursive(set, n, sum))
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");

		int[][] dp = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(isSubsetSumMemoized(set, n, sum, dp));

		System.out.println(isSubSetSumTabular(set, sum));
	}

	public static boolean isSubsetSumRecursive(int[] arr, int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		if (arr[n - 1] > sum) {
			return isSubsetSumRecursive(arr, n - 1, sum);
		} else {
			return isSubsetSumRecursive(arr, n - 1, sum) || isSubsetSumRecursive(arr, n - 1, sum - arr[n - 1]);
		}
	}

	public static boolean isSubsetSumMemoized(int[] arr, int n, int sum, int[][] dp) {
		if (sum == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		if (dp[n][sum] != -1) {
			return dp[n][sum] == 1;
		}

		if (arr[n - 1] > sum) {
			dp[n][sum] = isSubsetSumRecursive(arr, n - 1, sum) ? 1 : 0;
		} else {
			dp[n][sum] = (isSubsetSumRecursive(arr, n - 1, sum) || isSubsetSumRecursive(arr, n - 1, sum - arr[n - 1])) ? 1 : 0;
		}
		return dp[n][sum] == 1;
	}

	public static boolean isSubSetSumTabular(int[] arr, int sum) {
		int n = arr.length;
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
		return dp[n][sum];
	}

}
