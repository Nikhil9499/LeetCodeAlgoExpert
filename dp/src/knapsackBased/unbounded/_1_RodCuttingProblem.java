package knapsackBased.unbounded;

public class _1_RodCuttingProblem {
	public static void main(String[] args) {
		int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(rodCutting(price, price.length));
		System.out.println(cutRod(price, price.length));
	}

	public static int rodCutting(int[] price, int n) {
		int len[] = {1, 2, 3, 4, 5, 6, 7, 8};

		int[][] dp = new int[n + 1][len.length + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= len.length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (len[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - len[i - 1]]);
				}
			}
		}

		return dp[n][len.length];
	}

	public static int cutRod(int price[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner and return
		// the last entry from the table
		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				max_val = Math.max(max_val, price[j] + val[i - j - 1]);
			val[i] = max_val;
		}

		return val[n];
	}
}
