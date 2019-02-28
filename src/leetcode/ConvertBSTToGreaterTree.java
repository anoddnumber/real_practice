package leetcode;

public class ConvertBSTToGreaterTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        if (root == null) return null;

        root.right = convertBST(root.right);
        sum += root.val;
        root.val = sum;
        root.left = convertBST(root.left);

        return root;
    }
}
