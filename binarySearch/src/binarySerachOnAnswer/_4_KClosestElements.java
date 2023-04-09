package binarySerachOnAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a sorted integer array arr, two integers k and x, return the k the closest integers to x in the array. The result should also be sorted in ascending order.

        An integer a is closer to x than an integer b if:

        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b


Example 1:

        Input: arr = [1,2,3,4,5], k = 4, x = 3
        Output: [1,2,3,4]

        Example 2:
        Input: arr = [1,2,3,4,5], k = 4, x = -1
        Output: [1,2,3,4]
*/


public class _4_KClosestElements {

    public static void main(String[] args) {
        int[]nums = {1,2,3,4,5};
        int k=2, x=3;
        System.out.println(findClosestElements(nums, k, x));
        System.out.println(findClosestElements2(nums, k, x));

        int[]nums2 = {1,2,3,4,5};
        k=4; x=-1;
        System.out.println(findClosestElements(nums2, k, x));
        System.out.println(findClosestElements2(nums2, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (p1, p2) -> p1.getA() != p2.getA() ? p2.getA() - p1.getA() : p2.getB() - p1.getB()
        );

        int n = arr.length;
        for (int i=0; i<n; i++) {
            maxHeap.add(new Pair(Math.abs(arr[i]-x), arr[i]));
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            ans.add(maxHeap.remove().getB());
        }

        Collections.sort(ans);
        return ans;
    }

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k, mid;
        while(low < high) {
            mid = low + (high -low)/2;
//            System.out.println(mid);
            if (x - arr[mid] > arr[mid+k] - x)
                low = mid + 1;
            else
                high = mid;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i< low+k; i++)
            result.add(arr[i]);
//        int mod=1000000007;
        return result;
    }

    static public class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
