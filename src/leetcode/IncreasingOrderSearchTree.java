package leetcode;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    // tail will be the reference to the rightmost node
    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;

        TreeNode newRoot = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);

        return newRoot;
    }
}
