public class Node {
	public int data;
	public Node next;

	public Node() {
	}

	Node(int d) {
		data = d;
		next = null;
	}

	public static void display(Node head) {
		while(head!=null){
			if (head.next != null) {
				System.out.print(head.data + " -> ");
			} else {
				System.out.print(head.data);
			}
			head = head.next;
		}
		System.out.println();
	}
}