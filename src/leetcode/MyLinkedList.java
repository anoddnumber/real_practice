package leetcode;

class MyLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head = null;
    int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        /*
            Time Complexity - O(n)
         */
        if (index < 0 || index >= this.size) return -1;
        Node runner = this.head;
        for (int i = 0; i < index; i++) {
            runner = runner.next;
        }
        return runner.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        /*
            Time Complexity - O(n)
         */
        if (index < 0 || index > this.size) return;
        this.size++;
        Node newNode = new Node(val, null);
        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        Node runner = this.head;
        for (int i = 0; i < index - 1; i++) {
            runner = runner.next;
        }
        Node next = runner.next;
        runner.next = newNode;
        newNode.next = next;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        /*
            Time Complexity - O(n)
         */
        if (index < 0 || index >= this.size) return;
        this.size--;
        if (index == 0) {
            Integer value = this.head.val;
            this.head = this.head.next;
            return;
        }

        Node runner = this.head;
        for (int i = 0; i < index - 1; i++) {
            runner = runner.next;
        }
        Node newNext = runner.next.next;
        runner.next = newNext;
    }

    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
//        l.addAtIndex(1,2);
//        l.addAtHead(1);
//        l.addAtIndex(1,2);
//        l.get(1);
//        l.get(0);
//        l.get(2);

        l.addAtHead(5);
        l.addAtHead(2);
        l.deleteAtIndex(1);
        l.addAtIndex(1,9);
        l.addAtHead(4);
        l.addAtHead(9);
        l.addAtHead(3);
        l.get(1);
        l.addAtTail(1);
//        l.addAtIndex(3, 6);
//        l.addAtHead(3);
        System.out.println("hi");
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
