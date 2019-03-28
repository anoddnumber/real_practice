package leetcode;

import java.util.HashSet;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
            Time Complexity - O(n) where n is the length of nums
            Space Complexity - O(k)
         */
        if (k <= 0) return false;
        HashSet<Integer> s = new HashSet<>();

        int index = 0;
        while (index < nums.length && index <= k) {
            int num = nums[index];
            if (s.contains(num)) {
                return true;
            }
            s.add(num);
            index++;
        }

        while (index < nums.length) {
            s.remove(nums[index - k - 1]);
            int num = nums[index];
            if (s.contains(num)) {
                return true;
            }
            s.add(num);
            index++;
        }
        return false;
    }
}
