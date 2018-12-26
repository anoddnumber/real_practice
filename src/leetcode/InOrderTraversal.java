package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values. Note:
 * Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class InOrderTraversal {

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
//		TreeNode node = new TreeNode(5);
//		List<TreeNode> test = new LinkedList<TreeNode>();
//		test.add(node);
//		node = new TreeNode(2);
//		
//		System.out.println("test: " + test.get(0).val);
//		
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
		
		
		
		InOrderTraversal test = new InOrderTraversal();
		List<Integer> nums = test.inorderTraversalBetter(root);
		System.out.println("nums: " + nums);
		
	}
	
	public List<Integer> inorderTraversalBetter(TreeNode cur) {
		List<Integer> res = new LinkedList<Integer>();
		Stack<TreeNode> todo = new Stack<TreeNode>();
		
		while (! todo.isEmpty() || cur != null) {
			if (cur != null) {
				todo.push(cur);
				cur = cur.left;
			} else {
				cur = todo.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}
		return res;
	}
	
//omg this is actually really messy, above is better
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while ( ! stack.isEmpty()) {
			TreeNode leftMostNode = lookLeft(stack.pop(), list, stack);
			if (leftMostNode == null) {
				continue;
			}
			while (leftMostNode.right != null) {
				leftMostNode = lookLeft(leftMostNode.right, list, stack);
			}
			while ( ! stack.isEmpty() && (leftMostNode = backUp(list, stack)) == null) {}
		}
		return list;
	}
	
	public TreeNode backUp(List<Integer> listSoFar, Stack<TreeNode> stack) {
		if (stack.isEmpty()) {
			return null;
		}
		TreeNode node = stack.pop();
		listSoFar.add(node.val);
		if (node.right != null) {
			stack.push(node.right);
			return node.right;
		}
		
		return null;
	}
	
	public TreeNode lookLeft(TreeNode start, List<Integer> listSoFar, Stack<TreeNode> stack) {
		if (start == null) {
			return null;
		}
		
		while (start.left != null) {
			stack.push(start);
			start = start.left;
		}
		listSoFar.add(start.val);
		return start;
	}
}
