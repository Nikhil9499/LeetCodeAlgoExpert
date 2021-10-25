public class _1_NthNodeFromLast {
	static Node head;
	static int i = 0;

	public static void main(String[] args) {
		push(20);
		push(4);
		push(15);
		push(35);

		Node.display(head);

		printNthFromLast(4);
		printNthFromLast(1);
		printNthFromLast(2);
		printNthFromLast(3);
		printNthFromLast(0);

		printNthFromLast(head, 4);
		i = 0;
		printNthFromLast(head, 1);
		i = 0;
		printNthFromLast(head, 2);
		i = 0;
		printNthFromLast(head, 3);
		i = 0;
		printNthFromLast(head, 0);

		printNthFromLast2Pointers(4);
		printNthFromLast2Pointers(1);
		printNthFromLast2Pointers(2);
		printNthFromLast2Pointers(3);
		printNthFromLast2Pointers(0);


	}

	static void printNthFromLast(int n) {

		if (n <= 0) {
			System.out.println("Invalid input");
			return;
		}

		int len = 0;
		Node temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.next;
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n) {
			System.out.println("Invalid input");
			return;
		}

		temp = head;

		// 2) get the (len-n+1)th node from the beginning
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.next;

		System.out.println(temp.data);
	}

	public static void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	static void printNthFromLast(Node head, int n) {

		if (head == null)
			return;
		printNthFromLast(head.next, n);

		if (++i == n)
			System.out.println(head.data);
	}

	static void printNthFromLast2Pointers(int n) {
		if (n<=0) {
			System.out.println("Invalid input");
			return;
		}
		Node main_ptr = head;
		Node ref_ptr = head;

		int count = 0;
		if (head != null) {
			while (count < n) {
				if (ref_ptr == null) {
					System.out.println(n + " is greater than the no " + " of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}

			if (ref_ptr == null) {

				if (head != null)
					System.out.println("Node no. " + n + " from last is " + head.data);
			} else {

				while (ref_ptr != null) {
					main_ptr = main_ptr.next;
					ref_ptr = ref_ptr.next;
				}
				System.out.println("Node no. " + n + " from last is " + main_ptr.data);
			}
		}
	}

}
