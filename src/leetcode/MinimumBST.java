package leetcode;

public class MinimumBST {
	 // Definition for a binary tree node.
	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
    public int getMinimumDifference(TreeNode root) {
    	if (root == null) return -1;
    	int maxLeft = this.getMaxLeftVal(root);
    	int minRight = this.getMinRightVal(root);
    	if (maxLeft == -1 && minRight == -1) return -1;
    	if (maxLeft == -1) return minRight - root.val;
    	if (minRight == -1) return root.val - maxLeft;
    	
        int min = Math.min(root.val - maxLeft, minRight - root.val);
        
        int minLeft = this.getMinimumDifference(root.left);
        minRight = this.getMinimumDifference(root.right);
        
        min = Math.min(this.getMinimumDifference(root.left), this.getMinimumDifference(root.right));
        return min;
    }
    
    public int getMaxLeftVal(TreeNode root) {
    	if (root == null) return -1;
    	if (root.left == null) return -1;
    	TreeNode node = root.left;
    	while(node.right != null) {
    		node = node.right;
    	}
    	return node.val;
    }
    
    public int getMinRightVal(TreeNode root) {
    	if (root == null) return -1;
    	if (root.right == null) return -1;
    	TreeNode node = root.right;
    	while(node.left != null) {
    		node = node.left;
    	}
    	return node.val;
    }
    
    public static void main(String[] args) {
//    	TreeNode root = new TreeNode(1);
//    	root.right = new TreeNode(3);
//    	root.right.left = new TreeNode(2);
    	
//    	MinimumBST bst = new MinimumBST();
//    	System.out.println(bst.getMinimumDifference(root));
    }
}
