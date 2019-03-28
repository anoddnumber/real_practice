package leetcode;

import java.util.Stack;

public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 
    public boolean isPalindrome(ListNode head) {
        /*
            Time Complexity - O(n) where n is the size of the LinkedList
            Space Complexity - O(n)
         */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Stack<Integer> s = new Stack<>();
        while (slow != null) {
            s.push(slow.val);
            slow = slow.next;
        }

        fast  = head;
        while (fast != null && fast.next != null) {
            if (s.isEmpty() || s.pop() != head.val) {
                return false;
            }
            head = head.next;
            fast = fast.next.next;
        }
        return true;
    }
}
