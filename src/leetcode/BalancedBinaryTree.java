package leetcode;

public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n) due to the number of recursive calls
         */
        return dfs(root) != -1;
    }

    // returns -1 if the tree is not "balanced"
    // otherwise returns the height of the tree
    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfs(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = dfs(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
