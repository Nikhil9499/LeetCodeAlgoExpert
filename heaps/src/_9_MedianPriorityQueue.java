import java.util.Collections;
import java.util.PriorityQueue;

public class _9_MedianPriorityQueue {

	private PriorityQueue<Integer> left, right;

	public _9_MedianPriorityQueue() {
		left = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap
		right = new PriorityQueue<>(); // minHeap
	}

	public static void main(String[] args) {
		_9_MedianPriorityQueue obj = new _9_MedianPriorityQueue();
		obj.addNum(1);
		obj.addNum(2);
		System.out.println(obj.findMedian());
		obj.addNum(3);
		System.out.println(obj.findMedian());
	}

	public void addNum(int num) {
		if (right.size() > 0 && right.peek() < num) {
			right.add(num);
		} else {
			left.add(num);
		}

		if (left.size() - right.size() > 1) {
			right.add(left.remove());
		} else if (right.size() - left.size() > 1) {
			left.add(right.remove());
		}
	}

	public double findMedian() {
		if (left.size() > 0 || right.size() > 0) {
			if (left.size() > right.size()) {
				return left.peek();
			} else if (left.size() < right.size()) {
				return right.peek();
			} else {
				return (left.peek() + right.peek()) / 2.0;
			}
		} else {
			return 0.0;
		}
	}
}
