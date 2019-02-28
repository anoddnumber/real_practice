package leetcode;

import java.util.HashMap;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        /*
            Time Complexity - O(n) where n is the number of integers in the array
            Space Complexity - O(n)
         */
        // key is the number, value is the index of the number
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int complement = target - number;
            Integer complementIndex = map.get(complement);
            if (complementIndex != null) {
                return new int[]{complementIndex, i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return new int[]{-1, -1};
    }
}
