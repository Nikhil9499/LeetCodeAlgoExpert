package binaryTree.traversals;

import binaryTree.Node;
import binaryTree.Tree;

public class Inorder {
    public static void main(String[] args) {
        Node root = Tree.getRoot();
        inorder(root);
    }

    public static void inorder(Node root) {
        if (root == null) {
           return;
        }

        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }
}
