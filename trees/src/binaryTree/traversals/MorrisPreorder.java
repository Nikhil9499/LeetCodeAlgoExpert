package binaryTree.traversals;

import binaryTree.Node;
import binaryTree.Tree;

/*
Given the root of a binary tree, flatten the tree into a "linked list":

        The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
        The "linked list" should be in the same order as a pre-order traversal of the binary tree.
*/

public class MorrisPreorder {
    public static void main(String[] args) {
        Node root = Tree.getRoot();
        Node root2 = Tree.getRoot2();

        LevelOrder.levelOrder(root);
        flattenTreeIntoLinkedList(root);
        System.out.println();
        LevelOrder.levelOrder(root);

        System.out.println("###################");

        LevelOrder.levelOrder(root2);
        flattenTreeIntoLinkedList(root2);
        System.out.println();
        LevelOrder.levelOrder(root2);

    }

    public static void flattenTreeIntoLinkedList(Node node) {
        Node curr = node;

        while (curr != null) {
            if (curr.left != null) {
                Node pred = predecessor(curr);
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    public static Node predecessor(Node node) {
        Node predecessor = node.left;

        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }

        return predecessor;
    }
}
