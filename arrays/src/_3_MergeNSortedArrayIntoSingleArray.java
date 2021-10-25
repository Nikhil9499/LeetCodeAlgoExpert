import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class _3_MergeNSortedArrayIntoSingleArray {
	public static void main(String[] args) {
		int[][]matrix = {
			{1,3,5,7,9},
			{0,2,4,6,8,10},
			{33,54},
			{21,44}
		};
		//System.out.println(mergeNSortedArray(matrix));
		System.out.println(mergeNSortedArrayEfficient(matrix));
	}

	// Space: O(mn) & Time: mn log(mn)
	public static List<Integer> mergeNSortedArray(int[][]matrix) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				minHeap.add(matrix[i][j]);
			}
		}
		List<Integer> ans = new ArrayList<>();
		while(!minHeap.isEmpty()) {
			ans.add(minHeap.remove());
		}
		return ans;
	}

	// Space: O(row) & time: row*col Log(col)
	public static List<Integer> mergeNSortedArrayEfficient(int[][]matrix) {
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<Triplet> minHeap = new PriorityQueue<>((a,b) -> a.a-b.a);

		for (int i=0; i<matrix.length; i++) {
			minHeap.add(new Triplet(matrix[i][0],i,0));
		}

		while(!minHeap.isEmpty()) {
			Triplet minTriplet = minHeap.remove();
			ans.add(minTriplet.a);

			minTriplet.c++;

			if (minTriplet.c < matrix[minTriplet.b].length) {
				minHeap.add(new Triplet(matrix[minTriplet.b][minTriplet.c], minTriplet.b, minTriplet.c));
			}
		}

		return ans;
	}

}
