import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String []args){
        int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        solution(arr);
    }
    public static void solution(int[] arr){
        int[]dp = new int[arr.length];

        dp[arr.length - 1] = 0;
        for (int i=arr.length-2; i>=0; i--) {
            if (arr[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j=1; j<=arr[i] && j+i<arr.length; j++) {
                min = Math.min(min, dp[i+j]);
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = 1 + min;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }

        System.out.println(dp[0]);
    }

}
