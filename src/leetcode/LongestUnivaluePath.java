package leetcode;

public class LongestUnivaluePath {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int longestUnivaluePath = 0;

    public int longestUnivaluePath(TreeNode root) {
        /*
            Time Complexity - O(n*log(n)) where n is the number of nodes in the tree
            Space Complexity - O(h) where h is the height of the tree

            The solution they give has time complexity O(n) instead since you can actually just process each node once
            instead of repeating..
         */
        if (root == null) return 0;
        helper(root);
        return longestUnivaluePath - 1;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        findLongestPathFromRoot(root);
        helper(root.left);
        helper(root.right);
    }

    private int findLongestPathFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = findStreak(root.left, root.val) + findStreak(root.right, root.val) + 1;
        longestUnivaluePath = Math.max(longestUnivaluePath, result);
        return result;
    }

    private int findStreak(TreeNode root, int val) {
        if (root == null || root.val != val) {
            return 0;
        }

        int left = findStreak(root.left, val);
        int right = findStreak(root.right, val);

        return Math.max(left, right) + 1;
    }
}
