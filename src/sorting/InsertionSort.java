package sorting;

import java.util.Arrays;

public class InsertionSort {

    private static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j >= 1 && nums[j] < nums[j-1]) {
                int tmp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = tmp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,7,3,8,5};
        InsertionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
