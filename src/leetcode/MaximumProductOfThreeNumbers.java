package leetcode;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        /*
            Time Complexity - O(n * log(n))
            Space Complexity - O(log(n)) due to the recursion of sorting
         */
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[len - 1] * nums[0] * nums[1]);
    }

}
