package binaryTree;

import java.util.StringJoiner;

public class Node {
	public int data;
	public Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}

	Node(int data, binaryTree.Node left, binaryTree.Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]").add("data=" + data).add("left=" + left)
			.add("right=" + right).toString();
	}
}
