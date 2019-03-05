package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 
    public int diameterOfBinaryTree(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        setLongestPath(root);

        int diameter = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        while (root != null) {

            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
            }

            int distance = 0;
            if (root.left != null) {
                distance += root.left.val + 1;
            }

            if (root.right != null) {
                distance += root.right.val + 1;
            }

            diameter = Math.max(diameter, distance);
            root = q.poll();
        }

        return diameter;
    }

    private int setLongestPath(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            root.val = 0;
            return 0;
        }
        int longestPath = Math.max(1 + setLongestPath(root.left), 1 + setLongestPath(root.right));
        root.val = longestPath;
        return longestPath;
    }
}
