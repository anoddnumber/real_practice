package leetcode;

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            min = Math.min(min, num);
        }
        return sum - min * nums.length;
    }

}
