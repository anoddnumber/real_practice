package leetcode;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class UnivaluedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }

    boolean isUnivalTree(TreeNode root, int value) {
        if (root == null) return true;
        if (root.val != value) return false;
        return isUnivalTree(root.left, value) && isUnivalTree(root.right, value);
    }

    public static void main(String[] args) {

    }
}
