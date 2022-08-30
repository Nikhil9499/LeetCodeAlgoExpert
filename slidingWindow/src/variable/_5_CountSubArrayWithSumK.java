package variable;

import java.util.HashMap;

public class _5_CountSubArrayWithSumK {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -1, 1, 9};
        int k = 10;
        System.out.println("Count = " + countSubArraySumK(arr, k));
    }

    public static int countSubArraySumK(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1); // key = sum & value = count
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            System.out.println(map + " -> " + count);
        }
        return count;
    }

}
