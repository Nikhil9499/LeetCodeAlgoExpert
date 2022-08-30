package binaryTree;

import java.util.StringJoiner;

public class Node {
	public int data, val;
	public Node left, right;

	Node(int data) {
		this.data = data;
		this.val = data;
		left = right = null;
	}

	Node(int data, binaryTree.Node left, binaryTree.Node right) {
		this.data = data;
		this.val = data;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node{" +
				"data=" + data +
				", val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
