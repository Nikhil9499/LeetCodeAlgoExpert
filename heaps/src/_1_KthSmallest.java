import java.util.PriorityQueue;

public class _1_KthSmallest {
	public static void main(String[] args) {
		int[]arr = {4,3,1,6,7,2};
		int k = 3;
		System.out.println(kthSmallest(arr, k));
	}

	public static int kthSmallest(int[]arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
		for (int val: arr) {
			maxHeap.add(val);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}
}
