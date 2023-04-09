package binaryTree.top50Questions.level1;

import binaryTree.Node;
import binaryTree.Tree;

// Two trees are identical when they have the same data and the arrangement of data is also the same
public class IdenticalTree {
    public static void main(String[] args) {
        Node root = Tree.getRoot();
        Node root2 = Tree.getRoot2();
        System.out.println(isIdenticalTree(root, root2));

        root = Tree.getIdenticalTreeRoot();
        root2 = Tree.getIdenticalTreeRoot();
        System.out.println(isIdenticalTree(root, root2));
    }

    public static boolean isIdenticalTree(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isIdenticalTree(root1.left, root2.left) && isIdenticalTree(root1.right, root2.right);
    }
}
