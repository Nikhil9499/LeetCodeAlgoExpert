import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(nums[i]);
            permutations(nums, ans, curr, (i+1)%nums.length);
//            curr.clear();
        }
        return ans;
    }

    public static void permutations(int[]nums, List<List<Integer>> ans, List<Integer> curr, int idx) {
        if (curr.size() == nums.length) {
            ans.add(curr);
            return;
        }

        if (idx >= nums.length) {
            return;
        }

        if (curr.contains(nums[idx])) {
            return;
        }

        curr.add(nums[idx]);
        permutations(nums, ans, curr, (idx+1)%nums.length);
//        curr.remove(nums[idx]);
    }


}
