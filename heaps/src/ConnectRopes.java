import java.util.PriorityQueue;

public class ConnectRopes {
	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 6 };
		System.out.println(minCost(arr));
	}

	public static int minCost(int[]arr) {
		int minCost = 0;

		if (arr.length == 1) {
			return 0;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i=0; i<arr.length; i++)
			minHeap.add(arr[i]);

		while(minHeap.size() > 1) {
			int min = minHeap.remove() + minHeap.remove();
			minCost += min;
			minHeap.add(min);
		}

		return minCost;
	}
}
