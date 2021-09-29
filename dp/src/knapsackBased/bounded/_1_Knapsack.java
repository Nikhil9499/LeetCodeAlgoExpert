package knapsackBased.bounded;

import java.util.Arrays;

public class _1_Knapsack {
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapsackRecursive(wt, val, n, W));

		int[][]dp = new int[n+1][W+1];
		for (int i=0; i<=n; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(knapsackMemoized(wt, val, n, W, dp));
		for (int i=0; i<=n; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(knapsackTabular(wt, val, n, W, dp));
	}

	public static int knapsackRecursive(int[]wt, int[]val, int n, int W) {
		if (n == 0 || W == 0) {
			return 0;
		}

		if (wt[n-1] > W) {
			return knapsackRecursive(wt, val, n-1, W);
		} else {
			return Math.max(knapsackRecursive(wt, val, n-1, W), val[n-1] + knapsackRecursive(wt, val, n-1, W-wt[n-1]));
		}
	}

	public static int knapsackMemoized(int[]wt, int[]val, int n, int W, int[][]dp) {
		if (n == 0 || W == 0) {
			return 0;
		}

		if (dp[n][W] != -1) {
			return dp[n][W];
		}

		if (wt[n-1] > W) {
			return dp[n][W] = knapsackRecursive(wt, val, n-1, W);
		} else {
			return dp[n][W] = Math.max(knapsackRecursive(wt, val, n-1, W), val[n-1] + knapsackRecursive(wt, val, n-1, W-wt[n-1]));
		}
	}

	public static int knapsackTabular(int[]wt, int[]val, int n, int W, int[][]dp) {
		for (int i=0; i<=n; i++) {
			for (int w=0; w<=W; w++) {
				if (i==0 || w==0) {
					dp[i][w] = 0;
				} else if (w < wt[i-1]) {
					dp[i][w] = dp[i-1][w];
				} else {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-wt[i-1]] + val[i-1]);
				}
			}
		}
		return dp[n][W];
	}
}
