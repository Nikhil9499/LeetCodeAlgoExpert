import java.util.Stack;

public class _9_MinimumElementInStack {
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(2);
		obj.push(3);
		obj.push(1);
		obj.push(5);
		System.out.println("popped element: " + obj.pop());
		int top = obj.top();
		System.out.println("Top: " + top);
		int min = obj.getMin();
		System.out.println("minimum: " + min);
		System.out.println("popped element: " + obj.pop());
		min = obj.getMin();
		System.out.println("minimum: " + min);
	}

	static class MinStack {

		private Stack<Integer> stack;
		private Stack<Integer> minStack;

		public MinStack() {
			stack = new Stack<>();
			minStack = new Stack<>();
		}

		public void push(int val) {
			stack.push(val);
			if (minStack.isEmpty() || minStack.peek() >= val) {
				minStack.push(val);
			}
		}

		public int pop() {
			if (stack.isEmpty()) {
				return -1;
			}

			int val = stack.pop();
			if (!minStack.isEmpty() && minStack.peek() == val) {
				minStack.pop();
			}
			return val;
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return minStack.peek();
		}
	}
}


