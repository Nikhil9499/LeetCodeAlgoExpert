import java.util.HashSet;

public class Product2Numbers {
	public static void main(String[] args) {
		int[] arr = {1,4,5,7,8,2,3};
		int target = 20;
		product2Numbers(arr, target);
	}

	public static void product2Numbers(int[]arr, int target) {
		HashSet<Integer> set = new HashSet<>();

		for (int num: arr) {
			if (target % num == 0) {
				int newTarget = target/num;
				if (set.contains(newTarget)) {
					System.out.println(num+" "+newTarget);
				} else {
					set.add(num);
				}
			}
		}
	}
}
