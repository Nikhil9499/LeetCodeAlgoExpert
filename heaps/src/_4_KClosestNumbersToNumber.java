import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _4_KClosestNumbersToNumber {
	public static void main(String[] args) {
		int[] arr = {3, 5, 8, 7, 6, 9, 10};
		int k = 5;
		int num = 7;
		System.out.println(kClosestNumbers(arr, k, num));
	}

	public static List<Integer> kClosestNumbers(int[] arr, int k, int num) {
		List<Integer> ans = new ArrayList<>();

		PriorityQueue<Pair> maxHeap =
			new PriorityQueue<>((a, b) -> b.getB() - a.getB() == 0 ? a.getA() - b.getA() : b.getB() - a.getB());

		for (int i = 0; i < arr.length; i++) {
			maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - num)));
			if (maxHeap.size() > k) {
				maxHeap.remove();
			}
		}

		while (maxHeap.size() > 0) {
			ans.add(maxHeap.remove().getA());
		}

		Collections.reverse(ans);
		return ans;
	}
}
