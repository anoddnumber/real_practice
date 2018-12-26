package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 */
public class NextRightPointers {

	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeLinkNode> todo = new LinkedList<TreeLinkNode>();
		
		todo.add(root);
		
		while ( ! todo.isEmpty()) {
			TreeLinkNode node = todo.remove();
			if (node.left != null) {
				node.left.next = node.right;
				todo.add(node.left);
			}
			if (node.right != null) {
				if (node.next != null) {
					node.right.next = node.next.left;
				}
				todo.add(node.right);
			}
		}
	}
	
	//use constant space
	public void connectBetter(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		TreeLinkNode currParent = root;
		TreeLinkNode leftMostParent = currParent;
		
		while (leftMostParent != null) {
			while (currParent != null) {
				if (currParent.left != null) {
					currParent.left.next = currParent.right;
				}
				if (currParent.right != null) {
					if (currParent.next != null) {
						currParent.right.next = currParent.next.left;
					}
				}
				
				currParent = currParent.next;
			}
			leftMostParent = leftMostParent.left;
			currParent = leftMostParent;
		}
	}
	
	
	
	public void connectRecursive(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.right != null && root.next != null) {
			root.right.next = root.next.left;
		}
		connectRecursive(root.left);
		connectRecursive(root.right);
	}
}
