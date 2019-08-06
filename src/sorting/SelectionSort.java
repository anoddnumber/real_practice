package sorting;

import java.util.Arrays;

public class SelectionSort {

    static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,7,3,5,8};
        SelectionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
