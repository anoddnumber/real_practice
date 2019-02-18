package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        /**
         * Time Complexity - O(n) where n is the number of nodes in the tree
         * Space Complexity - O(n)
         */
        Queue<TreeNode> parents = new LinkedList<>();
        Queue<TreeNode> children = new LinkedList<>();
        Queue<TreeNode> tmpParents = new LinkedList<>();
        Queue<TreeNode> tmpChildren = new LinkedList<>();

        children.add(root);
        while (!children.isEmpty()) {
            TreeNode n = children.poll();
            if (n != null) {
                if (n.val == x || n.val == y) {
                    return isCousins(parents, x, y);
                }

                tmpParents.add(n);
                tmpChildren.add(n.left);
                tmpChildren.add(n.right);
            }

            if (children.isEmpty()) {
                parents = tmpParents;
                children = tmpChildren;
                tmpParents = new LinkedList<>();
                tmpChildren = new LinkedList<>();
            }
        }

        return false;
    }

    /**
     * Returns true if both x and y are cousins of each other and also children of the TreeNodes in parents
     */
    private boolean isCousins(Queue<TreeNode> parents, int x, int y) {
        int count = 0;

        while (! parents.isEmpty()) {
            TreeNode n = parents.poll();
            if (isChild(n, x) || isChild(n, y)) {
                if (isSiblings(n, x, y))
                    return false;
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSiblings(TreeNode parent, int x, int y) {
        return isChild(parent, x) && isChild(parent, y);
    }

    private boolean isChild(TreeNode parent, int x) {
        return parent.left != null && parent.left.val == x || parent.right != null && parent.right.val == x;
    }

}
