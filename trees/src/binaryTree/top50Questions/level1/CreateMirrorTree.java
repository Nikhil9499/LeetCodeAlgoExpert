package binaryTree.top50Questions.level1;

import binaryTree.Node;
import binaryTree.Tree;
import binaryTree.traversals.LevelOrder;

public class CreateMirrorTree {
    public static void main(String[] args) {
        Node root = Tree.getRoot2();
        LevelOrder.levelOrder(root);
        System.out.println();
        mirror(root);
    }

    public static void mirror(Node root) {
        if (root == null) {
            return;
        }
        LevelOrder.levelOrder(createMirrorTree(root));
    }

    private static Node createMirrorTree(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left == null || root.right == null) {
            return root;
        }

        Node left = createMirrorTree(root.left);
        Node right = createMirrorTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


}
