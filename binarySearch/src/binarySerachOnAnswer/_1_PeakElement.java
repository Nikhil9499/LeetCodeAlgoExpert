package binarySerachOnAnswer;

/*
A peak element is an element that is strictly greater than its neighbors.

        Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

        You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

        You must write an algorithm that runs in O(log n) time.



        Example 1:

        Input: nums = [1,2,3,1]
        Output: 2
        Explanation: 3 is a peak element and your function should return the index number 2.
        Example 2:

        Input: nums = [1,2,1,3,5,6,4]
        Output: 5
        Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

*/

public class _1_PeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElementRecursive(nums));

        nums= new int[] {5,4,3,2,1};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElementRecursive(nums));

        nums= new int[] {3,4,3,2,1};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElementRecursive(nums));
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n-1] > nums[n-2]) {
            return n-1;
        }

        int low = 0, high = n-1, mid;
        while(low <= high) {
            mid = low + (high - low)/2;

            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
                return mid;
            } else if (nums[mid] < nums[mid+1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int findPeakElementRecursive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        if (n==1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n-1] > nums[n-2]) {
            return n-1;
        }

        return binSearchOnAns(nums, 0, n-1);
    }

    public static int binSearchOnAns(int[]nums, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high-low)/2;
        if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])) {
            return mid;
        } else if (nums[mid] < nums[mid+1]) {
            return binSearchOnAns(nums, mid+1, high);
        } else {
            return binSearchOnAns(nums, low, mid-1);
        }


    }
}
