package binarySerachOnAnswer;

/*You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls.
For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Return the minimum possible penalty after performing the operations.
Examples:
        Input: nums = [9], maxOperations = 2
        Output: 3
        Explanation:
        - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
        - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
        The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.

        Input: nums = [2,4,8,2], maxOperations = 4
        Output: 2
        Explanation:
        - Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
        - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
        - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
        - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
        The bag with the most number of balls has 2 balls, so your penalty is 2 an you should return 2.

        Input: nums = [7,17], maxOperations = 2
        Output: 7
*/

public class _2_Minimum_Limit_Balls_In_Bag {

    public static void main(String[] args) {
        int[]arr= {9};
//        System.out.println(minimumSize(arr, 2));
//        System.out.println(minimumSize2(arr, 2));
//        System.out.println(minimumSize3(arr, 2));
        arr = new int[]{2,4,8,2};
//        System.out.println(minimumSize(arr, 4));
//        System.out.println(minimumSize2(arr, 4));
        System.out.println(minimumSize3(arr, 4));
        arr = new int[]{7,17};
//        System.out.println(minimumSize(arr, 2));
//        System.out.println(minimumSize(arr, 3));
//        System.out.println(minimumSize2(arr, 2));
//        System.out.println(minimumSize2(arr, 3));
//        System.out.println(minimumSize3(arr, 2));
//        System.out.println(minimumSize3(arr, 3));
    }

    public static int minimumSize3(int[] nums, int maxOperations) {
        int low = 1, high = Integer.MIN_VALUE, mid;

        for (int i=0; i<nums.length; i++) {
            high = Math.max(high, nums[i]);
        }
        int ans = -1;
        while(low <= high) {
            mid = low + (high-low)/2;
            System.out.print(mid+":"+ans);
            if (numOfOperations2(mid, nums, maxOperations)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean numOfOperations2(int penalty, int[] nums, int maxOperations){
        int ops = 0;
        for (int i=0; i<nums.length; i++) {
            ops += nums[i]/penalty;
            if (nums[i]%penalty == 0) ops--;
        }
        System.out.println(":"+ops);
        return ops <= maxOperations;
    }

    public static int minimumSize(int[]nums, int maxOperations) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int num: nums) {
            right = Math.max(right, num);
        }
        while(left < right){
            int mid = left + (right - left) / 2;
//            System.out.println(mid);
            // more means ans will be > mid
            if(numOfOperations(mid, nums) > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static int numOfOperations(int probablePenalty, int[] balls) {
        int operations = 0;
        for(int ball: balls) {
            operations += (ball - 1) / probablePenalty;
//            System.out.println(operations);
        }
        return operations;
    }

    public static int minimumSize2(int[] nums, int maxOperations) {
        int left = 1, right = Integer.MAX_VALUE - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += minOpsToReach(n, mid);
            }
            // System.out.println(mid + ", " + ops);
            // mid can be smaller
            if (ops <= maxOperations) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // System.out.println(minOpsToReach(9 ,1));
        return left;
    }

    public static int minOpsToReach(int num, int target) {
        return (num - 1) / target;
    }
}
