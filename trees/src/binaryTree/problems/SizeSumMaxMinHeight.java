package binaryTree.problems;

import binaryTree.Node;
import binaryTree.Pair;
import binaryTree.Tree;

import java.util.Map;

public class SizeSumMaxMinHeight {
    public static void main(String[] args) {
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
        Node root = Tree.getRoot();
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(maxMin(root));
        System.out.println(height(root));
        System.out.println();

        /* Create following Binary Tree
			 		20
				/   	 \
			  8     	  22
			/   \  		  /   \
		   5     3 		4     25
				/ \
			 10    14
		*/
        root = Tree.getRoot2();
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(maxMin(root));
        System.out.println(height(root));
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSize = size(root.left);
        int rightSize = size(root.right);

        return leftSize + rightSize + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;
    }

    public static Pair maxMin(Node root) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Pair leftMinMax = maxMin(root.left);
        Pair rightMinMax = maxMin(root.right);

        int max = Math.max(root.data, Math.max(leftMinMax.first, rightMinMax.first));
        int min = Math.min(root.data, Math.min(leftMinMax.second, rightMinMax.second));

        return new Pair(max, min);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }
}
