import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _5_FrequencySort {
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 4, 3, 2, 1, 3, 3, 3};
		frequencySort(arr);
	}

	public static void frequencySort(int[] arr) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int val : arr) {
			freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
		}

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.getB() - a.getB());
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
		}

		while (maxHeap.size() > 0) {
			System.out.println(maxHeap.poll());
		}
	}
}
