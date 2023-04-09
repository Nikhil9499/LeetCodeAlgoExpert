package binaryTree.traversals;

import binaryTree.Node;
import binaryTree.Tree;

public class Postorder {
    public static void main(String[] args) {
        Node root = Tree.getRoot();
        postorder(root);
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
