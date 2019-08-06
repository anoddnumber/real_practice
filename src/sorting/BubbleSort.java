package sorting;

import java.util.Arrays;

public class BubbleSort {

    static void sort(int[] nums) {
        boolean hasSwap;
        do {
            hasSwap = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i-1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = tmp;
                    hasSwap = true;
                }
            }
        } while(hasSwap);
    }

    public static void main(String[] args) {
        int[] nums = {4,2,7,3,8,5};
        BubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
