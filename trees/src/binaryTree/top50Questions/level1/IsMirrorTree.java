package binaryTree.top50Questions.level1;

import binaryTree.Node;
import binaryTree.Tree;

// Symmetric Tree (Mirror Image of itself)
public class IsMirrorTree {
    public static void main(String[] args) {
        Node root = Tree.getIdenticalTreeRoot();
        System.out.println(isSymmetric(root));

        root = Tree.getRoot2();
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(Node root) {
        if (root == null || Tree.isLeaf(root)) {
            return true;
        }

        return isSymmetricHelper(root, root);
    }

    public static boolean isSymmetricHelper(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return root1.data == root2.data && isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left);
    }

}
