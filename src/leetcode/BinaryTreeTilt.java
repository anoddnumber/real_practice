package leetcode;

import java.util.HashMap;

public class BinaryTreeTilt {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // I misread the problem at first... but we don't actually need a HashMap to make it fast. Oh well.
    HashMap<TreeNode, Integer> map = new HashMap<>();
    int sumOfTilts = 0;

    public int findTilt(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        computeTilt(root);
        return sumOfTilts;
    }

    public void computeTilt(TreeNode root) {
        if (root == null) return;
        findTilt(root.left);
        findTilt(root.right);
        int tilt = Math.abs(getSum(root.left) - getSum(root.right));
        sumOfTilts += tilt;
    }

    int getSum(TreeNode node) {
        if (node == null) return 0;
        if (map.containsKey(node)) {
            return map.get(node);
        }

        int sum = node.val + getSum(node.left) + getSum(node.right);
        map.put(node, sum);
        return sum;
    }

}
