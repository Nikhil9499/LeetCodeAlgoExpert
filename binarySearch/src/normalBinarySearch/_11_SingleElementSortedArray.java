package normalBinarySearch;
/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

        Return the single element that appears only once.

        Your solution must run in O(log n) time and O(1) space.

        Example 1:

        Input: nums = [1,1,2,3,3,4,4,8,8]
        Output: 2
        Example 2:

        Input: nums = [3,3,7,7,10,11,11]
        Output: 10
        */

public class _11_SingleElementSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr));
        System.out.println(singleNonDuplicate2(arr));

        int[] arr2 = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr2));
        System.out.println(singleNonDuplicate2(arr2));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        //Boundary cases.
        //In the array the last indexed value is 0 then return that 0 because the array doesn't contain -ve nums.
        if (end == 0){
            return nums[end];
        }


        //If the starting element is not equal to next element means that start element is the unique element.
        else if (nums[0] != nums[1]){
            return nums[0];
        }

        //If the last element is not equal to before element means that last element is the unique element.
        else if (nums[end] != nums[end-1]){
            return nums[end];
        }

        while (start <= end) {
            int mid = start + (end-start) / 2;

            //If both the mid+1 and mid-1 element are not equal to mid means that mid is unique element.
            if (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) {
                return nums[mid];
            }

            //Check for the index before the unique element the paired element start will be in even.
            if ((mid%2) == 0 && nums[mid] == nums[mid+1] || (mid%2) == 1 && nums[mid] == nums[mid-1]) {
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }

        return -1;
    }

    public static int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while(low <= high) {
            mid = low + (high - low)/2;

            if ((mid == 0 || nums[mid] != nums[mid-1]) && (mid == nums.length -1 || nums[mid] != nums[mid+1])) {
                return nums[mid];
            } else if ((mid%2 == 0 && nums[mid] == nums[mid+1]) || (mid%2==1 && nums[mid] == nums[mid-1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }
}
