package binaryTree;

public class SumMaxHtSize {

	public static int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public static int sum(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = sum(node.left);
		int rs = sum(node.right);

		int ts = ls + rs + node.data;
		return ts;
	}

	public static int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = max(node.left);
		int rmax = max(node.right);
		int max = Math.max(node.data, Math.max(lmax, rmax));
		return max;
	}

	public static int height(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		int currNodeHt = Math.max(lh, rh) + 1;
		return currNodeHt;
	}

	public static void main(String[] args) throws Exception {
		Node root = Tree.getRoot();

		int size = size(root);
		int sum = sum(root);
		int max = max(root);
		int ht = height(root);
		System.out.println(size);
		System.out.println(sum);
		System.out.println(max);
		System.out.println(ht);
	}
}