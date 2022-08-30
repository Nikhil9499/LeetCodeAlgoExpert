package binaryTree.traversals;

import binaryTree.Node;

public class Postorder {
    public static void main(String[] args) {

    }

    public static void postorder(Node root) {
        if(root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }
}
