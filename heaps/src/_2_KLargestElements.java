import java.util.*;

public class _2_KLargestElements {
		public static void main(String[] args) {
			int[]arr = {2,3,4,1,9,8,6,7,5,0};
			int k = 4;
			System.out.println(kLargestElements(arr, k).get(0)); // Ans: [9,8,7,6]
		}

		public static List<Integer> kLargestElements(int[]arr, int k) {
			List<Integer> ans = new ArrayList<>();

			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			for (int i=0; i<arr.length; i++) {
				minHeap.add(arr[i]);
				if (minHeap.size()>k){
					minHeap.remove();
				}
			}

			while(minHeap.size() > 0) {
				ans.add(minHeap.remove());
			}

			return ans;
		}
}
