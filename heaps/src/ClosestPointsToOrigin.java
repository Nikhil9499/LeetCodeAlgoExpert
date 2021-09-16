import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestPointsToOrigin {
	public static void main(String[] args) {
		int[][] arr = {
			{3,3},
			{5,-1},
			{-2,4}
		};
		int k = 3;
		System.out.println(Arrays.deepToString(closestPtsToOrigin(arr, k)));
	}

	public static int[][] closestPtsToOrigin(int[][]points, int k) {

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1]*b[1] + b[0]*b[0]) - (a[1]*a[1] + a[0]*a[0]));

		for (int i=0; i<k; i++) {
			maxHeap.add(points[i]);
		}

		for (int i=k; i< points.length; i++) {
			maxHeap.add(points[i]);
			if (maxHeap.size() > k) {
				maxHeap.remove();
			}
		}

		int[][] ans = new int[maxHeap.size()][2];

		int index = 0;
		while(maxHeap.size() > 0) {
			int[]temp = maxHeap.remove();
			ans[index][0] = temp[0];
			ans[index][1] = temp[1];
			index++;
		}
		return ans;
	}
}
