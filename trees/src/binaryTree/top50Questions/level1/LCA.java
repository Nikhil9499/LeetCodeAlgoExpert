package binaryTree.top50Questions.level1;

import binaryTree.Node;
import binaryTree.Tree;
import binaryTree.TreeNode;

public class LCA {

    private static Node LCA = null;
    private static boolean v1 = false, v2 = false;

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
        System.out.println(lca(root, 10, 14)); // 3
        lca2(root, 10, 14); // 3
        System.out.println(LCA);
        Node node = lca3(root, 10, 14);
        if (v1 && v2) {
            System.out.println(node);
        } else {
            System.out.println("null");
        }

        LCA = null;
        v1= false;
        v2 = false;
        System.out.println(lca(root, 10, 4)); // 20
        lca2(root, 10, 4); // 20
        System.out.println(LCA);
        node = lca3(root, 10, 4);
        if (v1 && v2) {
            System.out.println(node);
        } else {
            System.out.println("null");
        }

        LCA = null;
        v1= false;
        v2 = false;
        System.out.println(lca(root, 8, 22)); // 20
        lca2(root, 8, 22); // 20
        System.out.println(LCA);
        node = lca3(root, 8, 22);
        if (v1 && v2) {
            System.out.println(node);
        } else {
            System.out.println("null");
        }

        LCA = null;
        v1= false;
        v2 = false;
        System.out.println(lca(root, 10, 134)); // null
        lca2(root, 10, 134); // null
        System.out.println(LCA);
        node = lca3(root, 10, 134);
        if (v1 && v2) {
            System.out.println(node);
        } else {
            System.out.println("null");
        }
    }

    // Unable to handle cases when keys are not present
    public static Node lca(Node root, int d1, int d2) {
        if (root == null) {
            return null;
        }

        if (root.data == d1 || root.data == d2) {
            return root;
        }

        Node leftRes = lca(root.left, d1, d2);
        Node rightRes = lca(root.right, d1, d2);

        if (leftRes == null && rightRes == null) {
            return null;
        }

        if (leftRes != null && rightRes != null) {
            return root;
        } else if (leftRes != null) {
            return leftRes;
        } else {
            return rightRes;
        }

    }

    // Not working. Issue not known
    public static Node lca3(Node root, int d1, int d2) {
        if (root == null) {
            return null;
        }

        if (root.data == d1) {
            v1 = true;
            return root;
        }

        if (root.data == d2) {
            v2 = true;
            return root;
        }

        Node leftRes = lca3(root.left, d1, d2);
        Node rightRes = lca3(root.right, d1, d2);

        if (leftRes != null && rightRes != null) {
            return root;
        } else if (leftRes != null) {
            return leftRes;
        } else {
            return rightRes;
        }

    }

    // Able to handle cases when keys are not present
    public static boolean lca2(Node root, int d1, int d2) {
        if (root == null) {
            return false;
        }

        boolean self = root.data == d1 || root.data == d2;

        boolean leftRes = lca2(root.left, d1, d2);
        if (LCA != null) {
            return true;
        }

        boolean rightRes = lca2(root.right, d1, d2);
        if (LCA != null) {
            return true;
        }

        if ((leftRes && rightRes) || (self && leftRes) || (self && rightRes)) {
            LCA = root;
        }

        return leftRes || rightRes || self;
    }
}
