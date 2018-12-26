import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class PreOrderTraversal {

	// Definition for binary tree
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode ten = new TreeNode(10);
		TreeNode eleven = new TreeNode(11);
		TreeNode twelve = new TreeNode(12);
		TreeNode thirteen = new TreeNode(13);
		
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.right = six;
		four.left = seven;
		five.left = thirteen;
		six.left = eight;
		seven.right = nine;
		nine.left = ten;
		nine.right = eleven;
		ten.left = twelve;
		
		PreOrderTraversal test = new PreOrderTraversal();
		List<Integer> nums = test.preorderTraversal(root);
		System.out.println("nums: " + nums);
		
	}
	
	public List<Integer> preorderTraversal(TreeNode curr) {
		List<Integer> res = new LinkedList<Integer>();
		Stack<TreeNode> todo = new Stack<TreeNode>();
		
		while (curr != null || ! todo.isEmpty()) {
			if (curr != null) {
				res.add(curr.val);
				if (curr.right != null) {
					todo.push(curr.right);
				}
				curr = curr.left;
			} else {
				curr = todo.pop();
			}
		}
		return res;
	}
}
