package binaryTree.problems;

import binaryTree.Node;
import binaryTree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PrintNodesKLevelAwayFromANode {
    public static void main(String[] args) {
        /* Create following Binary Tree
			 		20
				/   	 \
			  8     	  22
			/   \  		  /   \
		   5     3 		4     25
				/ \
			 10    14
		*/
        Node root = Tree.getRoot2();
        int k = 2;
        int nodeData = 8;

        printNodesKLevelAway(root, k, nodeData); // 10 14 22(imp)
    }

    // combination of nodeToRootPath and printKLevelDownNodes
    // using blocker so that when we are traversing for other nodes, same side don't be traversed
    public static void printNodesKLevelAway(Node root, int k, int nodeData) {
        List<Node> nodeToRootPath = new ArrayList<>();
        NodeToRootPath.nodeToRootPathExist(root, nodeData, nodeToRootPath);

        if (nodeToRootPath.isEmpty()) {
            System.out.println(nodeData + " doesn't exist");
            return;
        }
        System.out.println(nodeToRootPath);
        int size = nodeToRootPath.size();
        for (int i=0; i<size; i++) {
//            System.out.println("Printing nodes from " + nodeToRootPath.get(i) + " at a distance of " + (k-i));
            printKLevelNodes(nodeToRootPath.get(i), k-i, i==0?null:nodeToRootPath.get(i-1));
        }
    }

    private static void printKLevelNodes(Node root, int k, Node blocker) {
        if (root == null || k < 0 || root == blocker) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printKLevelNodes(root.left, k-1, blocker); // imp: don't use k--
        printKLevelNodes(root.right, k-1, blocker); // imp: don't use k--
    }
}
