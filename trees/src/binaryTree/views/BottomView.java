package binaryTree.views;

import binaryTree.Node;
import binaryTree.NodePair;
import binaryTree.Pair;
import binaryTree.Tree;

import java.util.*;

public class BottomView {
	public static void main(String[] args) {
		Node root = Tree.getRoot();
		System.out.println(getBottomView(root));
		System.out.println(bottomViewIterative(root));

		Node root2 = Tree.getRoot2();
		System.out.println(getBottomView(root2));
		System.out.println(bottomViewIterative(root2));
	}

	public static List<Integer> getBottomView(Node root) {
		Map<Integer, Pair> map = new TreeMap<>();
		bottomViewUtil(root, 0, 0, map);

		List<Integer> ans = new ArrayList<>();
		for (Pair p: map.values()) {
			ans.add(p.first);
		}
		return ans;
	}

	public static void bottomViewUtil(Node root, int distance, int level, Map<Integer, Pair> map) {

		if (root == null) {
			return;
		}

		if (!map.containsKey(distance)) {
			map.put(distance, new Pair(root.data, level));
		} else {
			if (map.get(distance).second <= level) {
				map.put(distance, new Pair(root.data, level));
			}
		}

		bottomViewUtil(root.left, distance-1, level+1, map);
		bottomViewUtil(root.right, distance+1, level+1, map);
	}

	public static List<Integer> bottomViewIterative(Node root) {
		if (root == null) {
			return null;
		}

		Queue<NodePair> queue = new LinkedList<>();
		queue.add(new NodePair(root, 0));

		Map<Integer, NodePair> map = new TreeMap<>();

		while(!queue.isEmpty()) {
			NodePair nodePair = queue.poll();
			map.put(nodePair.second, nodePair);

			if (nodePair.node.left != null) {
				queue.add(new NodePair(nodePair.node.left, nodePair.second-1));
			}

			if (nodePair.node.right != null) {
				queue.add(new NodePair(nodePair.node.right, nodePair.second+1));
			}

		}

		List<Integer> ans = new ArrayList<>();
		for (Map.Entry<Integer, NodePair> entry: map.entrySet()) {
			ans.add(entry.getValue().node.data);
		}
		return ans;
	}
}
