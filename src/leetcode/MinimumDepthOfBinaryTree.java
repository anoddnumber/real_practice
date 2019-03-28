package leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        q.add(root);

        int level = 1;
        while (! q.isEmpty()) {
            TreeNode t = q.poll();

            if (t.left == null && t.right == null) {
                return level;
            }

            if (t.left != null) {
                tmp.add(t.left);
            }

            if (t.right != null) {
                tmp.add(t.right);
            }

            if (q.isEmpty()) {
                level++;
                q = tmp;
                tmp = new LinkedList<>();
            }
        }
        return 0;
    }
}
