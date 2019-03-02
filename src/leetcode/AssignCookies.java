package leetcode;

import java.util.Arrays;
//import java.util.Collections;
//import java.util.PriorityQueue;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        /*
            Time Complexity - O(n * log(n))
            Space Complexity - O(1)
         */
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int i = 0; // greed index
        int j = 0; // size index
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }

//    public int findContentChildren(int[] g, int[] s) {
//        // first attempt
//        if (g.length == 0 || s.length == 0) return 0;
//
//        // Use 2 max heaps
//        PriorityQueue<Integer> greeds = new PriorityQueue<>(g.length, Collections.reverseOrder());
//        PriorityQueue<Integer> sizes = new PriorityQueue<>(s.length, Collections.reverseOrder());
//
//        for (int greed : g) {
//            greeds.add(greed);
//        }
//
//        for (int size : s) {
//            sizes.add(size);
//        }
//
//        int count = 0;
//        while (!greeds.isEmpty() && !sizes.isEmpty()) {
//            int greed = greeds.peek();
//            int size = sizes.peek();
//
//            if (size >= greed) {
//                greeds.poll();
//                sizes.poll();
//                count++;
//            } else {
//                greeds.poll();
//            }
//        }
//        return count;
//    }

}
