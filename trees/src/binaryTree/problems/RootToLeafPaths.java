package binaryTree.problems;

import binaryTree.Node;
import binaryTree.Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {
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
        printAllRootToLeafPath(root, "");
        System.out.println();

        List<String> leafToRootPaths = new ArrayList<>();
        rootToLeafPaths(root, "", leafToRootPaths);
        System.out.println(leafToRootPaths);

        List<List<Integer>> leafToRootPaths2 = new ArrayList<>();
        rootToLeafPathsList(root, new ArrayList<>(), leafToRootPaths2);
        System.out.println(leafToRootPaths2);
    }

    public static void printAllRootToLeafPath(Node root, String psf) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.println(psf + root.data + " ");
            return;
        }

        printAllRootToLeafPath(root.left, psf + root.data + " ");
        printAllRootToLeafPath(root.right, psf + root.data + " ");
    }

    public static void rootToLeafPaths(Node root, String psf, List<String> leafToRootPaths) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafToRootPaths.add(psf + root.data + " ");
            return;
        }

        rootToLeafPaths(root.left, psf + root.data + " ", leafToRootPaths);
        rootToLeafPaths(root.right, psf + root.data + " ", leafToRootPaths);
    }

    public static void rootToLeafPathsList(Node root, List<Integer> psf, List<List<Integer>> leafToRootPaths) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            psf.add(root.data);
            leafToRootPaths.add(psf);
            psf.remove(Integer.valueOf(root.data));
            return;
        }
        psf.add(root.data);
        rootToLeafPathsList(root.left, psf, leafToRootPaths);
        rootToLeafPathsList(root.right, psf, leafToRootPaths);

    }

}
