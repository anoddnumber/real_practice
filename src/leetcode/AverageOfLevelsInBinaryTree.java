package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

     // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes
            Space Complexity - O(m) where m is the maximum number of nodes in a row
         */
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ret = new LinkedList<>();

        q.add(root);

        while (! q.isEmpty()) {
            int len = q.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode tn = q.poll();

                if (tn != null) {
                    sum += tn.val;
                    if (tn.left != null) {
                        q.add(tn.left);
                    }

                    if (tn.right != null) {
                        q.add(tn.right);
                    }
                }
            }
            ret.add(sum / len);
        }
        return ret;
    }

}
