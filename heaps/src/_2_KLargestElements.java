import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _2_KLargestElements {
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 1, 9, 8, 6, 7, 5, 0};
		int k = 4;
		System.out.println(kLargestElements(arr, k)); // Ans: [9,8,7,6]
	}

	public static List<Integer> kLargestElements(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : arr) {
			minHeap.add(num);
			if (minHeap.size() > k) {
				minHeap.remove();
			}
		}

		while (minHeap.size() > 0) {
			ans.add(minHeap.remove());
		}

		Collections.reverse(ans);
		return ans;
	}
}
