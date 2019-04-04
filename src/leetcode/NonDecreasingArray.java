package leetcode;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        /*
            Time Complexity - O(n) where n is the length of nums
            Space Complexity - O(1)
         */
        if (nums.length <= 1) return true;
        int prev = nums[0];
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                boolean one = isNonDecreasingArray(nums);
                nums[i-1] = tmp;
                nums[i] = tmp;
                boolean two = isNonDecreasingArray(nums);
                return one || two;
            }
            prev = nums[i];
        }
        return true;
    }

    private boolean isNonDecreasingArray(int[] nums) {
        if (nums.length <= 1) return true;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) return false;
            prev = nums[i];
        }
        return true;
    }
}
