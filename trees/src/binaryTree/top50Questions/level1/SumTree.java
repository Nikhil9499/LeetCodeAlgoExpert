package binaryTree.top50Questions.level1;

import binaryTree.Node;
import binaryTree.Tree;

// A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree.
// An empty tree is SumTree and the sum of an empty tree can be considered as 0.
// A leaf node is also considered as SumTree
/* Consider the following Binary Tree
			 		40
				/   	 \
			  8     	  12
			/   \  		 /   \
		   5     3 		4     8
		*/

public class SumTree {

    static class Res {
        int leftSum, rightSum;

        public Res(int leftSum, int rightSum) {
            this.leftSum = leftSum;
            this.rightSum = rightSum;
        }
    }

    public static void main(String[] args) {
        Node root = Tree.getSumTreeRoot();
        System.out.println(isSumTree(root));

        root = Tree.getRoot();
        System.out.println(isSumTree(root));
    }

    public static boolean isSumTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        boolean isLeftSumTree = isSumTree(root.left);
        boolean isRightSumTree = isSumTree(root.right);

        return isLeftSumTree && isRightSumTree && root.data == sum(root.left) + sum(root.right);
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        return root.data + sum(root.left) + sum(root.right);
    }

    public static boolean isSumTree(Node root, Res res) {
        if (root == null) {
            return true;
        }

        boolean leftSum = isSumTree(root.left, res);
        boolean rightSum = isSumTree(root.right, res);

        return leftSum && rightSum && (root.data == res.leftSum + res.rightSum);
    }
}
