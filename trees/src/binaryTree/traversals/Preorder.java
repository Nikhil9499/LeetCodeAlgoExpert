package binaryTree.traversals;

import binaryTree.Node;
import binaryTree.Tree;

public class Preorder {
    public static void main(String[] args) {
        Node root = Tree.getRoot();
        preorder(root);
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
