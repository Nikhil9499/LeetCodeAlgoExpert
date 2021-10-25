package fixed;

import java.util.*;

public class _4_MaximumInWindowSizeK {
	public static void main(String[] args) {
		int[] arr = {-7, -8, 7, 5, 7, 1, 6, 0};
		int k = 4;
		System.out.println(maximumNumberInWindowK(arr, k));
		System.out.println(maxNumInWindowK(arr, k));
	}

	// O(N log k)
	public static List<Integer> maximumNumberInWindowK(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();

		if (arr == null || arr.length == 0 || k == 0) {
			return ans;
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

		int i = 0;
		for (; i < k; i++)
			maxHeap.add(arr[i]);

		ans.add(maxHeap.peek());

		maxHeap.remove(arr[0]);

		for (; i < arr.length; i++) {
			maxHeap.add(arr[i]);
			ans.add(maxHeap.peek());
			maxHeap.remove(arr[i - k + 1]);
		}

		return ans;
	}

	// O(n)
	public static List<Integer> maxNumInWindowK(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();

		if (arr == null || arr.length == 0 || k == 0) {
			return ans;
		}

		Deque<Integer> deque = new LinkedList<>();

		int i = 0, j = 0, n = arr.length;

		while (j < n) {
			while (!deque.isEmpty() && arr[j] > deque.peekLast()) {
				deque.removeLast();
			}
			deque.addLast(arr[j]);

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (deque.isEmpty()) {
					ans.add(0);
				} else {
					if (arr[i] == deque.peekFirst()) {
						ans.add(deque.removeFirst());
					} else {
						ans.add(deque.peekFirst());
					}
				}
				i++;
				j++;
			}
		}

		return ans;

	}



}
