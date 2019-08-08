package sorting;

import java.util.Arrays;

public class QuickSort {

    private static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int beg, int end) {
        if (end - beg <= 0) return;
        int pi = partition(nums, beg, end);
        quickSort(nums, beg, pi - 1);
        quickSort(nums, pi + 1, end);
    }

    private static int partition(int[] nums, int beg, int end) {
        if (end - beg <= 0) return beg;
        int pVal = nums[beg];
        int ptr = beg + 1;
        for (int i = beg + 1; i <= end; i++) {
            if (nums[i] < pVal) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }

        int tmp = nums[ptr-1];
        nums[ptr-1] = nums[beg];
        nums[beg] = tmp;
        return ptr - 1;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,7,4,3,8,5};
        QuickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
