/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 *
 */
public class LinkedListCycle {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	//lol, not a great solution but it technically works.
	//there was a cool solution discussed about 2 runners, 1 slow, 1 fast.
	//they both start traversing the list at the same time, the fast one going 2 steps at a time
	//while the slow one goes 1 step at a time. If the fast runner ever equals the slow runner
	//then there is a cycle.
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		if (head.next == head) {
			return true;
		}
		ListNode n = head.next;
		head.next = head;
		return hasCycle(n);
	}
}
