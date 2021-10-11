package binaryTree.views;

import binaryTree.Node;
import binaryTree.NodePair;
import binaryTree.Pair;
import binaryTree.Tree;

import java.util.*;

public class TopView {
	public static void main(String[] args) {
		Node root = Tree.getRoot();
		System.out.println(getTopView(root));
		System.out.println(topViewIterative(root));

		Node root2 = Tree.getRoot2();
		System.out.println(getTopView(root2));
		System.out.println(topViewIterative(root2));
	}

	public static List<Integer> getTopView(Node root) {
		Map<Integer, Pair> map = new TreeMap<>();
		topViewUtil(root, 0, 0, map);

		List<Integer> ans = new ArrayList<>();
		for (Pair p: map.values()) {
			ans.add(p.first);
		}
		return ans;
	}

	public static void topViewUtil(Node root, int distance, int level, Map<Integer, Pair> map) {

		if (root == null) {
			return;
		}

		if (!map.containsKey(distance)) {
			map.put(distance, new Pair(root.data, level));
		} else {
			if (map.get(distance).second > level) {
				map.put(distance, new Pair(root.data, level));
			}
		}

		topViewUtil(root.left, distance-1, level+1, map);
		topViewUtil(root.right, distance+1, level+1, map);
	}

	public static List<Integer> topViewIterative(Node root) {
		if (root == null) {
			return null;
		}

		Queue<NodePair> queue = new LinkedList<>();
		queue.add(new NodePair(root, 0));

		Map<Integer, NodePair> map = new TreeMap<>();

		while(!queue.isEmpty()) {
			NodePair nodePair = queue.poll();

			if(!map.containsKey(nodePair.second)) {
				map.put(nodePair.second, nodePair);
			}

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
