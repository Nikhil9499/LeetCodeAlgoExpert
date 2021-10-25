package knapsackBased.unbounded;

import java.util.Arrays;

//	Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
//	how many ways can we make the change? The order of coins does not matter.
public class _2_CoinChange {
	public static void main(String[] args) {
		int arr[] = {2, 3, 5};
		int n = arr.length;
		int amt = 7;
		System.out.println(maxWays(arr, n, amt));
		System.out.println(countCombination(arr, n, amt));
		System.out.println(countPermutation(arr, n, amt));
	}

	public static int maxWays(int[] arr, int n, int target) {
		int[][] dp = new int[n + 1][target + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= target; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], 1 + dp[i][j - arr[i - 1]]);
				}
			}
		}
		printMatrix(dp);
		return dp[n][target];
	}


	public static int countCombination(int arr[], int n, int amt) {
		int[] dp = new int[amt + 1];
		// there is 1 combination to make 0 rupees.
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			// run for each coin and start from coin position only
			for (int j = arr[i]; j <= amt; j++) {
				// in order to make 7 from 2 coins, go and check no of ways to make 5(7-2) by using 2 coins
				dp[j] += dp[j - arr[i]];
			}
		}

		printArray(dp);
		return dp[amt];
	}

	public static int countPermutation(int coins[], int n, int amt) {
		int[] dp = new int[amt + 1];
		// there is 1 permutation to make 0 rupees.
		dp[0] = 1;

		for (int i = 1; i <= amt; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= coins[j]) {
					dp[i] += dp[i - coins[j]];
				}
			}
		}

		printArray(dp);
		return dp[amt];
	}



	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
		System.out.println();
	}
}
