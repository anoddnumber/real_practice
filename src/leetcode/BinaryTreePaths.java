package leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<String> paths = new LinkedList<>();
 
    public List<String> binaryTreePaths(TreeNode root) {
        /*
            Time Complexity - O(n) where n is the number of nodes in the tree
            Space Complexity - O(n) (the depth of the tree can be n)
         */
        dfs(root, "");
        return paths;
    }

    public void dfs(TreeNode root, String s) {
        if (root == null) return;
        String newStr = s.equals("") ? String.valueOf(root.val) : s + "->" + root.val;
        if (root.left == null && root.right == null) {
            paths.add(newStr);
        } else {
            dfs(root.left, newStr);
            dfs(root.right, newStr);
        }
    }
}
