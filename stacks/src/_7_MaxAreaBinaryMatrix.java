public class _7_MaxAreaBinaryMatrix {
	public static void main(String[] args) {
		int arr[][] = {
			{ 0, 1, 1, 0 },
			{ 1, 1, 1, 1 },
			{ 1, 1, 1, 1 },
			{ 1, 1, 0, 0 },
		};
		System.out.println(maxAreaBinaryMatrix(arr)); //ans: 8
	}

	public static int maxAreaBinaryMatrix(int[][]mat) {
		int ans = Integer.MIN_VALUE;
		int[] temp = new int[mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			for (int k = 0; k < mat[i].length; k++) {
				if (mat[i][k] == 1)
					temp[k] += mat[i][k];
				else
					temp[k] = 0;
			}
			ans = Math.max(ans, _6_MaxAreaHistogram.maxHistogramArea(temp, temp.length));
		}
		return ans;
	}
}
