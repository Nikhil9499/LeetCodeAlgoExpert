package binaryTree.traversals;

import binaryTree.Node;

public class Inorder {
    public static void main(String[] args) {

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
