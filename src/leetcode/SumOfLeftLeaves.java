package leetcode;

public class SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        if (isLeaf(root.left)) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    boolean isLeaf(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
}
