package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        /*
            Time Complexity - O(n) where n is the length of nums
            Space Complexity - O(n)
         */
        if (k < 0) return 0;
        int count = 0;

        if (k == 0) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) == 2) {
                    count++;
                }
            }
        } else {
            HashSet<Integer> s = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (s.contains(num)) {
                    continue;
                }

                if (s.contains(num + k)) {
                    count++;
                }

                if (s.contains(num - k)) {
                    count++;
                }
                s.add(num);
            }
        }

        return count;
    }
}
