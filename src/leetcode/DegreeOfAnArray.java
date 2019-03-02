package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        /*
            Time Complexity - O(n) where n is the number of elements in nums
            SpaceComplexity - O(n)
         */

        // store the min index and max index of each number in the array
        // compute the distance at the end for the ones with the maximum degree
        // return the smallest of those distances

        // key is the number
        // value is an integer array of length 3, which corresponds to the following:
        // [numOccurrences, minIndex, maxIndex]

        int maxOccurrence = 0;
        List<Integer> numsWithMaxOccurrence = new LinkedList<>();

        Map<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer[] values = map.get(num);
            int numOccurrences;
            int minIndex;
            int maxIndex;

            if (values == null) {
                numOccurrences = 1;
                minIndex = maxIndex = i;
            } else {
                numOccurrences = values[0] + 1;
                minIndex = values[1];
                maxIndex = i;
            }
            map.put(num, new Integer[] {numOccurrences, minIndex, maxIndex});
            if (numOccurrences > maxOccurrence) {
                maxOccurrence = numOccurrences;
                numsWithMaxOccurrence = new LinkedList<>();
                numsWithMaxOccurrence.add(num);
            } else if (numOccurrences == maxOccurrence) {
                numsWithMaxOccurrence.add(num);
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < numsWithMaxOccurrence.size(); i++) {
            Integer[] values = map.get(numsWithMaxOccurrence.get(i));
            int distance = values[2] - values[1] + 1;
            minDistance = Math.min(minDistance, distance);
        }
        return minDistance;
    }

}
