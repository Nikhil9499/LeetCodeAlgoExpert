package binaryTree.top50Questions.level1;

import binaryTree.Node;
import binaryTree.Tree;
import binaryTree.TreeNode;

public class DiameterOfTree {
    static class Ans {
        int a;

        public Ans(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Node root = Tree.getRoot();
        System.out.println(diameterOfBinaryTree(root));

        System.out.println(diameterOfBinaryTree2(root));
    }

    public static int diameterOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        Ans ans = new Ans(0);
        height(root, ans);
        return ans.a-1; // because we are printing no. of edges. If we need to print no. of vertices, don't do -1.
    }

    public static int height(Node root, Ans ans) {
        if (root == null) {
            return 0;
        }

        int leftHt = height(root.left, ans);
        int rightHt = height(root.right, ans);

        ans.a = Math.max(ans.a, leftHt+rightHt+1);
        return 1 + Math.max(leftHt, rightHt);
    }

    static class Pair {
        int first, second;
        Pair(int a, int b) {
            first = a;
            second = b;
        }
        Pair(){}
    }

    public static int diameterOfBinaryTree2(Node root) {
        Pair p = diameter(root);
        return p.first-1;
    }

    public static Pair diameter(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair leftAns = diameter(root.left);
        Pair rightAns = diameter(root.right);

        Pair ans = new Pair();
        ans.first = Math.max(leftAns.first, Math.max(rightAns.first, leftAns.second+rightAns.second+1)); // diameter
        ans.second = Math.max(leftAns.second, rightAns.second) + 1; // height

        return ans;

    }

}
