import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _10_MergeKSortedLists {
	public static void main(String[] args) {
		int arr[][] = {{5, 7, 15, 18}, {1, 8, 9, 17}, {1, 4, 7, 7}};
		System.out.println(mergeKSortedLists(arr));
	}

	// Time: mn(log k) and space: m(no. of rows)
	public static List<Integer> mergeKSortedLists(int arr[][]) {
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<Triplet> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x.c));

		for (int i = 0; i < arr.length; i++) {
			minHeap.add(new Triplet(i, 0, arr[i][0]));
		}

		while (minHeap.size() > 0) {
			Triplet triplet = minHeap.remove();
			ans.add(triplet.c);

			triplet.b++;

			if (triplet.b < arr[triplet.a].length) {
				triplet.c = arr[triplet.a][triplet.b];
				minHeap.add(triplet);
			}
		}

		return ans;
	}

	public static class Triplet {
		public int a, b, c;

		public Triplet(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
