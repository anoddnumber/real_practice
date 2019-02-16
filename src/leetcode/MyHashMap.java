package leetcode;

class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static final int NUM_BUCKETS = 100;
    private Node[] buckets = new Node[NUM_BUCKETS];

    /** Initialize your data structure here. */
    public MyHashMap() {
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = null;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = this.hash(key);
        if (this.buckets[index] == null) {
            this.buckets[index] = new Node(key, value);
        } else {
            Node n = this.buckets[index];
            while (n != null) {
                if (n.key == key) {
                    n.val = value;
                    break;
                }
                n = n.next;
            }

            if (n == null) {
                // add to the front of the bucket
                Node newNode = new Node(key, value);
                newNode.next = this.buckets[index];
                this.buckets[index] = newNode;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = this.hash(key);
        if (this.buckets[index] == null) {
            return -1;
        }

        Node n = this.buckets[index];
        while (n != null) {
            if (n.key == key) {
                return n.val;
            }
            n = n.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = this.hash(key);
        if (this.buckets[index] == null) {
            return;
        }

        Node prev = null;
        Node n = this.buckets[index];
        while (n != null) {
            if (n.key == key) {
                if (prev == null) {
                    this.buckets[index] = n.next;
                } else {
                    prev.next = n.next;
                }
                return;
            }
            prev = n;
            n = n.next;
        }
    }

    private int hash(int key) {
        return key % NUM_BUCKETS;
    }
}
