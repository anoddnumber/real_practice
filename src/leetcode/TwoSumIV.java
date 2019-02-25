package leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    Set<Integer> s = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        if (root == null) return false;
        if (s.contains(k - root.val)) return true;
        s.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
