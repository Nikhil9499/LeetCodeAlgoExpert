package binaryTree.top50Questions.level1;

import binaryTree.Node;
import binaryTree.Tree;
import binaryTree.TreeNode;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = Tree.getRoot();
        System.out.println(height(root));

        root = Tree.getRoot2();
        System.out.println(height(root));
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }
}
