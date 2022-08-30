package binaryTree.traversals;

import binaryTree.Node;

public class Preorder {
    public static void main(String[] args) {

    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
