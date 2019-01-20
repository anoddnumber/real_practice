package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    public int[][] kClosest(int[][] points, int K) {
        Comparator c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (getDistance(o1) > getDistance(o2)) {
                    return 1;
                } else if (getDistance(o1) < getDistance(o2)) {
                    return -1;
                }
                return 0;
            }

            // for the purpose of the comparison, we don't need to do the square root
            double getDistance(int[] arr) {
                return Math.pow(arr[0], 2) + Math.pow(arr[1], 2);
            }
        };

        // A Priority Queue is a Heap
        PriorityQueue<int[]> pq = new PriorityQueue(points.length, c);
        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }

        // Remove the K closest points
        int[][] kClosest = new int[K][2];
        for (int i = 0; i < K; i++) {
            kClosest[i] = pq.remove();
        }

        return kClosest;
    }

    public static void main(String[] args) {
        KClosestPoints k = new KClosestPoints();
        int[][] points = {
                {1, 3},
                {-2, 2},
                {1, 10}
        };

        System.out.println(Arrays.deepToString(k.kClosest(points, 2)));
    }
}
