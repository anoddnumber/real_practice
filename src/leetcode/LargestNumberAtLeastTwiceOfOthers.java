package leetcode;

public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        /*
            Time Complexity - O(n)
            Space Complexity - O(1)
         */
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                if (max != Integer.MIN_VALUE) {
                    secondLargest = max;
                }
                max = num;
                maxIndex = i;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return max >= 2 * secondLargest ? maxIndex : -1;
    }
}
