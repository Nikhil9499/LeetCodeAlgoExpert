package knapsackBased.bounded;

public class _4_CountSubsetsWithGivenSum {
	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 9, 12, 4};
		System.out.println(countSubsetsWithGivenSum(arr, 34, arr.length));
		System.out.println(countSubsetsWithGivenSum(arr, 4, arr.length));

		System.out.println(countSubsetsWithGivenSumRecursive(arr, arr.length, 34));
		System.out.println(countSubsetsWithGivenSumRecursive(arr, arr.length, 4));
	}

	public static int countSubsetsWithGivenSum(int[] arr, int sum, int n) {
		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = 0;
				} else if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		return dp[n][sum];
	}

	public static int countSubsetsWithGivenSumRecursive(int[] arr, int n, int sum) {
		if (sum == 0) {
			return 1;
		}

		if (n == 0) {
			return 0;
		}

		if (arr[n - 1] > sum) {
			return countSubsetsWithGivenSumRecursive(arr, n - 1, sum);
		} else {
			return countSubsetsWithGivenSumRecursive(arr, n - 1, sum) + countSubsetsWithGivenSumRecursive(arr, n - 1,
				sum - arr[n - 1]);
		}

	}
}
