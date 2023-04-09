package recursion;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {3,6,1,1,8,4};
        sortArray(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortArray(int[]arr, int n) {
        if (n<=0) {
            return;
        }

        sortArray(arr, n-1);
        insertAtCorrectIndex(arr, n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertAtCorrectIndex(int[]arr, int n) {
        if (n<=0) {
            return;
        }
        // Not needed, just for understanding. I could have used arr[n]<arr[n-1] directly
        if (arr[n] >= arr[n-1]) {
            return;
        } else {
            int tmp = arr[n];
            arr[n] = arr[n-1];
            arr[n-1] = tmp;
            insertAtCorrectIndex(arr, n-1);
        }
    }
}
