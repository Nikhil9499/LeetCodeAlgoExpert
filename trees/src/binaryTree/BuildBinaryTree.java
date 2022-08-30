package binaryTree;

import binaryTree.traversals.LevelOrder;

import java.util.Scanner;

public class BuildBinaryTree {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Node root = buildTree(null);
        LevelOrder.levelOrder(root);
    }

    public static Node buildTree(Node root) {
        System.out.println("Enter the value for the node:");
        int val = sc.nextInt();
        if (val == -1) {
            return null;
        }
        root = new Node(val);
        System.out.println("Going to fill left subtree for " + root.val);
        root.left = buildTree(root.left);

        System.out.println("Going to fill right subtree for " + root.val);
        root.right = buildTree(root.right);

        return root;
    }
}
