package leetcode;

public class TrimABinarySearchTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public TreeNode trimBST(TreeNode root, int L, int R) {
//        if (root == null) return null;
//        if (root.val >= L && root.val <= R) {
//            root.left = trimBST(root.left, L, R);
//            root.right = trimBST(root.right, L, R);
//            return root;
//        } else {
//            if (root.val < L) {
//                return trimBST(root.right, L, R);
//            } else {
//                return trimBST(root.left, L, R);
//            }
//        }
//    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        if (root == null) return null;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
