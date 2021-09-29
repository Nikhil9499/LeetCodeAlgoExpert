package knapsackBased.bounded;

public class _3_EqualSumPartition {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;
		System.out.println(equalSumPartition(arr, n));
	}

	public static boolean equalSumPartition(int[]arr, int n) {
		int sum = 0;
		for (int ele: arr) {
			sum += ele;
		}

		if (sum % 2 != 0) {
			return false;
		}

		int sumToBeSearched = sum/2;
		return isSubSetSum(arr, sumToBeSearched, n);
	}

	public static boolean isSubSetSum(int[]arr, int sum, int n) {
		boolean[][]dp = new boolean[n+1][sum+1];

		for (int i=0; i<=n; i++) {
			for (int j=0; j<=sum; j++) {
				if (j==0) {
					dp[i][j] = true;
				} else if (i==0) {
					dp[i][j] = false;
				} else if (arr[i-1] <= j) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][sum];
	}
}
