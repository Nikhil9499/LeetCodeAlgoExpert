import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
	public static void main(String[] args) {
		int[]arr = {4,3,5,4,6,7,2,9};
		System.out.println(stockSpan(arr));
	}

	public static List<Integer> stockSpan(int[]arr) {
		List<Integer> ans = new ArrayList<>();

		if (arr == null || arr.length == 0){
			return ans;
		}

		Stack<Integer> stack = new Stack<>();

		return ans;
	}
}
