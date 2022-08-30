import java.util.ArrayList;
import java.util.List;

public class _11_ImplementPriorityQueueUsingList {

	private List<Integer> arrayList;
	private int capacity = 16;

	public _11_ImplementPriorityQueueUsingList() {
		arrayList = new ArrayList<>(capacity);
	}

	public static void main(String[] args) {
		_11_ImplementPriorityQueueUsingList obj = new _11_ImplementPriorityQueueUsingList();
		obj.add(3);
		obj.add(15);
		obj.add(17);
		obj.add(1);
		System.out.println(obj.peek());
		obj.add(20);
		obj.add(23);
		obj.add(12);
		obj.add(10);
		System.out.println(obj.size());
		System.out.println(obj.peek());
		System.out.println(obj.remove());
		System.out.println(obj.peek());
		System.out.println(obj.size());
	}

	public int peek() {
		if (size() <= 0) {
			return Integer.MAX_VALUE;
		}
		return arrayList.get(0);
	}

	public void add(int num) {
		arrayList.add(num);
		upHeapify(arrayList.size() - 1);
	}

	private void upHeapify(int i) {
		int parent = (i - 1) / 2;

		if (arrayList.get(parent) > arrayList.get(i)) {
			swap(i, parent);
			upHeapify(parent);
		}
	}

	private void swap(int i, int j) {
		int iTh = arrayList.get(i);
		arrayList.set(i, arrayList.get(j));
		arrayList.set(j, iTh);
	}

	public int remove() {
		if (size() <= 0) {
			return Integer.MAX_VALUE;
		}
		swap(0, size() - 1);
		int val = arrayList.remove(size() - 1);
		downHeapify(0);
		return val;
	}

	private void downHeapify(int parent) {
		int left = 2 * parent + 1;
		int right = 2 * parent + 2;

		int min = parent;

		if (left < size() && arrayList.get(left) < arrayList.get(min)) {
			min = left;
		}
		if (right < size() && arrayList.get(right) < arrayList.get(min)) {
			min = right;
		}

		if (min != parent) {
			swap(min, parent);
			downHeapify(min);
		}
	}

	public int size() {
		return arrayList.size();
	}

}
