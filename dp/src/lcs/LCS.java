package lcs;

public class LCS {
    public static void main(String[] args) {
        String a = "abcdgh";
        String b = "abedfhg";
        int m = a.length();
        int n = b.length();

        System.out.println(lcsRecursive(a, b, m, n));
        int[][] dp = new int[m+1][n+1];
        System.out.println(lcsMemoized(a, b, m, n, dp));
    }

    public static int lcsRecursive(String a, String b, int m, int n) {
        if (m==0 || n==0) {
            return 0;
        }

        if (a.charAt(m-1) == b.charAt(n-1)) {
            return 1 + lcsRecursive(a, b, m-1, n-1);
        } else {
            return Math.max(lcsRecursive(a, b, m, n-1), lcsRecursive(a, b, m-1, n));
        }
    }

    public static int lcsMemoized(String a, String b, int m, int n, int[][]dp) {
        if (m == 0 || n==0) {
            return 0;
        }

        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        if (a.charAt(m-1) == b.charAt(n-1)) {
            return dp[m][n] = 1 + lcsMemoized(a, b, m-1, n-1, dp);
        } else {
            return dp[m][n] = Math.max(lcsMemoized(a, b, m, n-1, dp), lcsMemoized(a, b, m-1, n, dp));
        }
    }
}
