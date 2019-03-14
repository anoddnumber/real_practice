package leetcode;

import java.util.Arrays;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        /*
            Time Complexity - O(n) where n is the length of nums
            Space Complexity - O(1)
         */
        int dup = -1;
        int missing = -1;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = index + 1;
            } else {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }

        return new int[]{dup, missing};
    }

    public static void main(String[] args) {
        SetMismatch s = new SetMismatch();
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{2,3,4,4})));
    }
}
