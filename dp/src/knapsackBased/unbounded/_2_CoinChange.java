package knapsackBased.unbounded;

import java.util.Arrays;

//	Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
//	how many ways can we make the change? The order of coins does not matter.
public class _2_CoinChange {
	public static void main(String[] args) {
		int arr[] = {1, 2};
		int m = arr.length;
		int n = 2;
		System.out.println(maxWays(arr, m, n));
		System.out.println(count(arr, m, n));
	}

	public static int maxWays(int[]arr, int n, int target) {
		int[][]dp = new int[n+1][target+1];

		for (int i=0; i<=n; i++) {
			for (int j=0; j<=target; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				} else if (arr[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], 1 + dp[i][j-arr[i-1]]);
				}
			}
		}
		printMatrix(dp);
		return dp[n][target];
	}


	public static int count( int arr[], int m, int n )
	{
		// table[i] will be storing the number of solutions for
		// value i. We need n+1 rows as the table is constructed
		// in bottom up manner using the base case (n = 0)
		int table[]=new int[n+1];

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[] values
		// after the index greater than or equal to the value of the
		// picked coin
		for(int i=0; i<m; i++)
			for(int j=arr[i]; j<=n; j++)
				table[j] += table[j-arr[i]];
		printArray(table);
		return table[n];
	}

	public static void printMatrix(int[][]arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printArray(int[]arr) {
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
		System.out.println();
	}
}
