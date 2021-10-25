package fixed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2_FirstNegativeNumInWindowK {
	public static void main(String[] args) {
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		System.out.println(firstNegativeInWindowK(arr, k));
	}

	public static List<Integer> firstNegativeInWindowK(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();

		if (arr == null || arr.length == 0 || k < 0) {
			return ans;
		}

		Queue<Integer> queue = new LinkedList<>();

		int i = 0, j = 0, n = arr.length;

		while (j < n) {
			//System.out.println(queue + " j: " + j + " i: " + i);
			if (arr[j] < 0) {
				queue.offer(arr[j]);
			}

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (queue.isEmpty()) {
					ans.add(0);
				} else {
					if (queue.peek() == arr[i]) {
						ans.add(queue.poll());
					} else {
						ans.add(queue.peek());
					}
				}
				i++;
				j++;
			}
		}

		return ans;
	}
}
