import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArray {
	public static void main(String[] args) {
		int arr[] = {6, 5, 2, 3, 8, 10, 9};
		int k = 3;
		System.out.println(kSortedArray(arr, k));
	}

	public static List<Integer> kSortedArray(int[]arr, int k) {
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i=0; i<k; i++) {
			minHeap.add(arr[i]);
		}

		for (int i=k; i<arr.length; i++) {
			ans.add(minHeap.remove());
			minHeap.add(arr[i]);
		}

		while(minHeap.size() > 0) {
			ans.add(minHeap.remove());
		}

		return ans;
	}
}
