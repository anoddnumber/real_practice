package leetcode;

import java.util.*;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
            Time Complexity - O(n) where n is the size of nums2
            Space Complexity - O(n)
         */

        // Creating empty priority queue, this is a min heap
        // Turns out you can actually use a stack as well which may be more efficient
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Map<Integer, Integer> map = new HashMap<>();

        //create map from the number to the next greatest number to the right
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            while (!minHeap.isEmpty() && minHeap.peek() < num) {
                map.put(minHeap.poll(), num);
            }
            minHeap.add(num);
        }

        while (!minHeap.isEmpty()) {
            map.put(minHeap.poll(), -1);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        NextGreaterElement1 n = new NextGreaterElement1();

        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};

        // [-1, 3, -1]
        System.out.println(Arrays.toString(n.nextGreaterElement(n1, n2)));

        int[] n12 = {2,4};
        int[] n22 = {1,2,3,4};

        // [3, -1]
        System.out.println(Arrays.toString(n.nextGreaterElement(n12, n22)));
    }
}
