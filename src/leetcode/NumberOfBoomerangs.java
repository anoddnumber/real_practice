package leetcode;

import java.util.HashMap;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        /*
            Time Complexity - O(n ^ 2)
            Space Complexity - O(n)
         */

        // the key is the distance
        // the value is the number of points at that distance
        HashMap<Integer, Integer> map = new HashMap<>();

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int distance = getDistance(points[i], points[j]);
                int count = map.containsKey(distance) ? map.get(distance) + 1 : 1;
                map.put(distance, count);
            }

            for (Integer dist : map.keySet()) {
                int count = map.get(dist);
                result += count * (count - 1);
            }
            map.clear();
        }
        return result;
    }

    private int getDistance(int[] point1, int[] point2) {
        int one = point1[0] - point2[0];
        int two = point1[1] - point2[1];
        return one * one + two * two; // for this problem, it doesn't make a difference to do the square root
//        return (int) Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[0] - point2[0], 2));
    }
}
