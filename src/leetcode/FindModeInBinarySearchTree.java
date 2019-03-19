package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindModeInBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // key is the number
    // value is the count
    HashMap<Integer, Integer> map = new HashMap<>();
 
    public int[] findMode(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n)
         */
        traverse(root);
        List<Integer> l = new ArrayList<>();
        int maxCount = -1;

        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (count > maxCount) {
                l = new ArrayList<>();
                maxCount = count;
                l.add(key);
            } else if (count == maxCount) {
                l.add(key);
            }
        }

        int[] ret = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ret[i] = l.get(i);
        }
        return ret;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
    }


}
