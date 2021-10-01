import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and
we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
*/
public class _5_StockSpan {
	public static void main(String[] args) {
		int[]arr = {4,3,5,4,6,7,2,9};
		System.out.println(stockSpan(arr));
		int[] arr1 = {100, 80, 60, 70, 60, 75, 85};
		System.out.println(stockSpan(arr1));
		int[]arr2 = { 28,14,28,35,46,53,66,80,87,88};
		System.out.println(stockSpan(arr2));
	}

	public static List<Integer> stockSpan(int[]arr) {
		List<Integer> ans = new ArrayList<>();

		if (arr == null || arr.length == 0){
			return ans;
		}

		Stack<Pair> stack = new Stack<>();

		for (int i=0; i<arr.length; i++) {
			int ele = arr[i];

			while (!stack.isEmpty() && stack.peek().getA() < ele) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				ans.add(i+1);
			} else {
				ans.add(i-stack.peek().getB());
			}
			stack.push(new Pair(ele, i));

		}

		return ans;
	}
}
