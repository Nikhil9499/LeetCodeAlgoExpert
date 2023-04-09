package binaryTree.problems;

import binaryTree.Node;
import binaryTree.Tree;

public class PrintKLevelsNodes {
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
        int k = 2;
        printKLevelNodes(root, k);
        System.out.println();

        k = 1;
        printKLevelNodes(root, k);
        System.out.println();

        k = 0;
        printKLevelNodes(root, k);
    }

    public static void printKLevelNodes(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printKLevelNodes(root.left, k-1); // imp: don't use k--
        printKLevelNodes(root.right, k-1); // imp: don't use k--
    }
}
