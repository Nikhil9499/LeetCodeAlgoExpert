package binaryTree;

public class Tree {
	Node root;

	public Tree() {
		root = null;
	}

	public static void main(String[] args) {
		System.out.println("Trees with different format for testing.");
	}

	public static Node getRoot() {
		/* Create following Binary Tree
         1
        / \
        2 3
        \
         4
          \
           5
            \
             6
        */
		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.left.right.right = new Node(5);
		tree.root.left.right.right.right = new Node(6);

		return tree.root;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static Node getRoot2() {
		/* Create following Binary Tree
			 		20
				/   	 \
			  8     	  22
			/   \  		  /   \
		   5     3 		4     25
				/ \
			 10    14
		*/
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		Tree tree = new Tree();
		tree.root = root;

		return tree.root;
	}

	public static Node getIdenticalTreeRoot() {
		/* Create following Binary Tree
         1
        / \
       2   2
        */
		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);

		return tree.root;
	}

	public static Node getSumTreeRoot() {
		/* Create following Binary Tree
			 		40
				/   	 \
			  8     	  12
			/   \  		 /   \
		   5     3 		4     8
		*/
		Node root = new Node(40);
		root.left = new Node(8);
		root.right = new Node(12);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(8);
		Tree tree = new Tree();
		tree.root = root;

		return tree.root;
	}

	public static boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
}
