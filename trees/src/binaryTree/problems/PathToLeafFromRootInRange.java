package binaryTree.problems;

import binaryTree.Node;
import binaryTree.Tree;

// Print all leaf to root paths for which sum is in [l, r]
public class PathToLeafFromRootInRange {
    public static void main(String[] args) {
        /* Create following Binary Tree
			 		20
				/   	 \
			  8     	  22
			/   \  		  /   \
		   5     3 		4     25
				/ \
			 10    14
		*/
        Node root = Tree.getRoot2();
        int l = 30;
        int r = 50;

        pathToLeafFromRootInRangeInclusive(root, "", 0, l, r);
    }

    public static void pathToLeafFromRootInRangeInclusive(Node root, String psf, int sum, int l, int r) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum += root.data;
            if (sum >= l && sum <= r) {
                System.out.println(psf + root.data);
            }
            return;
        }
        pathToLeafFromRootInRangeInclusive(root.left, psf+root.data +" ", sum + root.data, l, r);
        pathToLeafFromRootInRangeInclusive(root.right, psf+root.data +" ", sum + root.data, l, r);
    }
}
