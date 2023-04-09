package binaryTree.problems;

import binaryTree.Node;
import binaryTree.Tree;

import java.util.ArrayList;
import java.util.List;

public class NodeToRootPath {
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
        Node root2 = Tree.getRoot2();
        List<Node> path = new ArrayList<>();
        int target = 8;
        System.out.println(nodeToRootPathExist(root2, target, path));
        System.out.println(path);

        path = new ArrayList<>();
        target = 4;
        System.out.println(nodeToRootPathExist(root2, target, path));
        System.out.println(path);

        path = new ArrayList<>();
        target = 14;
        System.out.println(nodeToRootPathExist(root2, target, path));
        System.out.println(path);

        path = new ArrayList<>();
        target = 140;
        System.out.println(nodeToRootPathExist(root2, target, path));
        System.out.println(path);

    }

    // same as find Node exists function
    public static boolean nodeToRootPathExist(Node root, int target, List<Node> path) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            path.add(root);
            return true;
        }

        boolean isPresentInLeftTree = nodeToRootPathExist(root.left, target, path);
        if (isPresentInLeftTree) {
            path.add(root);
            return true;
        }

        boolean isPresentInRightTree = nodeToRootPathExist(root.right, target, path);
        if (isPresentInRightTree) {
            path.add(root);
            return true;
        }

        return false;
    }
}
