package binaryTree.traversals;

import binaryTree.Node;
import binaryTree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

	public static void main(String[] args) {
		levelOrder(Tree.getRoot());
	}

	public static void levelOrder(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				Node curr = queue.poll();
				System.out.print(curr.data + " ");

				if (curr.left != null) {
					queue.offer(curr.left);
				}

				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			System.out.println();

		}
	}
}
