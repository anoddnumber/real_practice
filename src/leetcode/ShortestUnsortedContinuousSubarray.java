package leetcode;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        // copy of the solution...
        /*
            Time Complexity - O(n)
            Space Complexity - O(1)
         */
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }

        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
//        System.out.println(s.findUnsortedSubarray(new int[]{1,3,2,2,2}));
        System.out.println(s.findUnsortedSubarray(new int[]{2,4,4,4,4,3,2,5,6,7,8}));
    }


}
