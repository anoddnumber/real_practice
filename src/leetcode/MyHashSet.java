package leetcode;

class MyHashSet {

    static class Node {
        Node next;
        int val;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static final int MAX_BUCKETS = 50;
    Node[] buckets = new Node[MAX_BUCKETS];

    /** Initialize your data structure here. */
    public MyHashSet() {
    }

    public void add(int key) {
        /*
            Time Complexity - O(1)
         */
        if (contains(key)) {
            return;
        }

        int hash = hash(key);
        if (this.buckets[hash] == null) {
            this.buckets[hash] = new Node(key, null);
        } else {
            this.buckets[hash] = new Node(key, this.buckets[hash]);
        }
    }

    public void remove(int key) {
        /*
            Time Complexity - O(1)
         */
        int hash = hash(key);
        Node prev = null;
        Node runner = this.buckets[hash];
        while (runner != null) {
            if (runner.val == key) {
                if (prev == null) {
                    this.buckets[hash] = runner.next;
                } else {
                    prev.next = runner.next;
                }
                return;
            }
            prev = runner;
            runner = runner.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        /*
            Time Complexity - O(1)
         */
        int hash = hash(key);
        Node runner = this.buckets[hash];
        while (runner != null) {
            if (runner.val == key) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    private int hash(int key) {
        return key % buckets.length;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}