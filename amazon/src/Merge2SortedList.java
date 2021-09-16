public class Merge2SortedList {

	static class Node {
		int data;
		Node next;
	}

	static Node newNode(int key) {
		Node temp = new Node();
		temp.data = key;
		temp.next = null;
		return temp;
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	static Node mergeIterative(Node h1, Node h2) {
		Node dummy = new Node();
		Node res = dummy;

		while (h1 != null && h2 != null) {
			if (h1.data < h2.data) {
				dummy.next = h1;
				h1 = h1.next;
			} else {
				dummy.next = h2;
				h2 = h2.next;
			}
			dummy = dummy.next;
		}

		while(h1 != null) {
			dummy.next = h1;
			dummy = dummy.next;
			h1 = h1.next;
		}

		while(h2 != null) {
			dummy.next = h2;
			h2 = h2.next;
			dummy = dummy.next;
		}

		return res.next;
	}

	static Node mergeRecursive(Node h1, Node h2) {
		if (h1 == null) return h2;
		if (h2 == null) return h1;

		if (h1.data < h2.data) {
			h1.next = mergeRecursive(h1.next, h2);
			return h1;
		} else {
			h2.next = mergeRecursive(h1, h2.next);
			return h2;
		}

	}

	public static void main(String[] args)
	{
		Node head1 = newNode(1);
		head1.next = newNode(3);
		head1.next.next = newNode(5);

		Node head2 = newNode(0);
		head2.next = newNode(2);
		head2.next.next = newNode(4);

		Node t1 = head1, t2=head2;
		Node mergedHead = mergeRecursive(t1, t2);

		printList(mergedHead);
		System.out.println();

		head1 = newNode(1);
		head1.next = newNode(3);
		head1.next.next = newNode(5);

		head2 = newNode(0);
		head2.next = newNode(2);
		head2.next.next = newNode(4);

		t1 = head1; t2=head2;

		if (t1 == null && t2 == null) {
			System.out.println("Both lists are null/empty");
			mergedHead = null;
		} else if(t1 == null) {
			mergedHead = t2;
		} else if (t2 == null) {
			mergedHead = t1;
		} else {
			if (t1.data < t2.data) {
				mergedHead = mergeIterative(t1, t2);
			} else {
				mergedHead = mergeIterative(t2, t1);
			}
		}
		printList(mergedHead);
	}
}


