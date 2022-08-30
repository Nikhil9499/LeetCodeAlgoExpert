package binaryTree.views;

import binaryTree.Node;
import binaryTree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public static void main(String[] args) {
        Node root = Tree.getRoot();
        System.out.println(rightSideView(root));
        System.out.println(rightSideViewIterative(root));
        List<Integer> ans = new ArrayList<>();
        rightViewRecursive2(root, 1, new MaxLevel(), ans);
        System.out.println(ans);

        Node root2 = Tree.getRoot2();
        System.out.println(rightSideView(root2));
        System.out.println(rightSideViewIterative(root2));
        ans.clear();
        rightViewRecursive2(root2, 1, new MaxLevel(), ans);
        System.out.println(ans);
    }

    public static List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        dfs(root,ans,0);
        return ans;
    }
    public static void dfs(Node root, List<Integer> ans, int depth){
        if(root == null)return;

        if(depth == ans.size()) ans.add(root.data);

        dfs(root.right,ans,depth+1);
        dfs(root.left,ans,depth+1);
    }

    public static List<Integer> rightSideViewIterative(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();

            for (int i=0; i<n; i++) {
                Node node = q.remove();
                if (i == n-1) {
                    ans.add(node.data);
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

        }

        return ans;
    }

    public static void rightViewRecursive2(Node node, int level, MaxLevel maxLevel, List<Integer> ans) {

        // Base Case
        if (node == null)
            return;

        // If this is the last Node of its level
        if (maxLevel.maxLevel < level) {
            ans.add(node.data);
            maxLevel.maxLevel = level;
        }

        // Recur for right subtree first, then left subtree
        rightViewRecursive2(node.right, level + 1, maxLevel, ans);
        rightViewRecursive2(node.left, level + 1, maxLevel, ans);
    }

    static class MaxLevel {
        int maxLevel;
    }
}
