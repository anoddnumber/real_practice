package leetcode;

import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums1) {
            s.add(i);
        }

        int count = 0;
        for (int i : nums2) {
            if (s.contains(i)) {
                nums1[count] = i;
                s.remove(i);
                count++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, count);
    }
}
