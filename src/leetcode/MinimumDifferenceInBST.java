package leetcode;

public class MinimumDifferenceInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int prev = -1;
    int min = -1;

    public int minDiffInBST(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        if (root == null) return -2;

        minDiffInBST(root.right);

        if (prev != -1) {
            if (min == -1) {
                min = prev - root.val;
            } else {
                min = Math.min(min, prev - root.val);
            }
        }

        prev = root.val;

        minDiffInBST(root.left);

        return min;
    }
}
