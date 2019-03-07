package leetcode;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        for (int num : nums) {
            this.minHeap.add(num);
        }
        while (minHeap.size() > k) {
            this.minHeap.remove();
        }
        this.k = k;
    }

    public int add(int val) {
        /*
            Time Complexity - O(log(k))
            Space Complexity - O(k)
         */
        if (this.minHeap.size() < this.k) {
            this.minHeap.add(val);
            return this.minHeap.peek();
        }

        if (val < this.minHeap.peek()) {
            return this.minHeap.peek();
        }

        this.minHeap.remove();
        this.minHeap.add(val);
        return this.minHeap.peek();
    }

}
