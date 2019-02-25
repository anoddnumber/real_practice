package datastructures;

public class LinkedList {

    // this is simply an exercise. I am assuming all valid inputs for the arguments.

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

    int indexOf(Integer i) {
        /*
            Time Complexity - O(n)
         */
        int count = 0;
        Node runner = head;
        while (runner != null) {
            if (runner.val == i) {
                return count;
            }
            count++;
            runner = runner.next;
        }
        return -1;
    }

    int lastIndexOf(Integer i) {
        /*
            Time Complexity - O(n)
         */
        int pos = -1;
        int count = 0;
        Node runner = head;
        while (runner != null) {
            if (runner.val == i) {
                pos = count;
            }
            count++;
            runner = runner.next;
        }

        return pos;
    }

    Integer set(int index, Integer element) {
        /*
            Time Complexity - O(n)
         */
        Node runner = head;
        for (int i = 0; i < index; i++) {
            runner = runner.next;
        }
        Integer prev = runner.val;
        runner.val = element;
        return prev;
    }

    int size() {
        /*
            Time Complexity - O(1)
         */
        return this.size;
    }

    LinkedList subList(int fromIndex, int toIndex) {
        /*
            Time Complexity - O(n)
         */
        LinkedList list = new LinkedList();
        Node runner = head;
        for (int i = 0; i < fromIndex; i++) {
            runner = runner.next;
        }

        for (int i = 0; i < toIndex - fromIndex; i++) {
            list.add(runner.val);
            runner = runner.next;
        }
        return list;
    }

    void add(int index, Integer element) {
        /*
            Time Complexity - O(n)
         */
        this.size++;
        Node newNode = new Node(element, null);
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

    boolean add(Integer element) {
        /*
            Time Complexity - O(n)
         */
        this.size++;
        if (this.head == null) {
            this.head = new Node(element, null);
            return true;
        }
        Node prev = null;
        Node runner = this.head;
        while(runner != null) {
            prev = runner;
            runner = runner.next;
        }
        prev.next = new Node(element, null);
        return true;
    }

    void clear() {
        /*
            Time Complexity - O(1)
         */
        this.size = 0;
        this.head = null;
    }

    Integer get(int index) {
        /*
            Time Complexity - O(n)
         */
        Node runner = this.head;
        for (int i = 0; i < index; i++) {
            runner = runner.next;
        }
        return runner.val;
    }

    boolean isEmpty() {
        /*
            Time Complexity - O(1)
         */
        return this.size == 0;
    }

    Integer remove(int index) {
        /*
            Time Complexity - O(n)
         */
        if (index == 0) {
            Integer value = this.head.val;
            this.head = this.head.next;
            return value;
        }

        Node runner = this.head;
        for (int i = 0; i < index - 1; i++) {
            runner = runner.next;
        }
        Node newNext = runner.next.next;
        Integer value = runner.next.val;
        runner.next = newNext;

        return value;
    }

    boolean remove(Integer value) {
        /*
            Time Complexity - O(n)
         */
        Node prev = null;
        Node runner = head;
        while (runner != null) {
            if (runner.val == value) {
                if (prev == null) {
                    this.head = this.head.next;
                } else {
                    prev.next = runner.next;
                }
                return true;
            }
            prev = runner;
            runner = runner.next;
        }
        return false;
    }

    void print() {
        System.out.print("[");
        Node runner = head;
        while (runner != null) {
            System.out.print(runner.val);
            if (runner.next != null) {
                System.out.print(", ");
            }
            runner = runner.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(6);
        list.add(5);
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(4);
        list.print(); // [3, 6, 5, 9, 4, 3, 4]

        System.out.println(list.get(5)); // 3
        list.subList(2, 5).print(); // [5, 9, 4]
        System.out.println(list.size()); // 7
        System.out.println(list.indexOf(9)); // 3
        System.out.println(list.lastIndexOf(3)); // 5
        System.out.println(list.remove(3)); // 9
        list.print(); // [3, 6, 5, 4, 3, 4]
        list.set(5, 7);
        list.print(); // [3, 6, 5, 4, 3, 7]
        list.clear();
        System.out.println(list.size()); // 0
        list.print(); // []
    }
}
