package sorting;

import java.util.Arrays;

public class MergeSort {

    static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int beg, int end) {
        if (end - beg <= 0) return;
        int mid = (beg + end) / 2;
        mergeSort(nums, beg, mid);
        mergeSort(nums, mid + 1, end);
//        merge(nums, beg, mid, mid + 1, end);
        merge2(nums, beg, end);
    }

    private static void merge(int[] nums, int beg1, int end1, int beg2, int end2) {
        int i1 = beg1;
        int i2 = beg2;
        int[] tmp = new int[end2 - beg1 + 1];
        int index = 0;

        while (i1 <= end1 || i2 <= end2) {
            if (i1 <= end1 && i2 <= end2) {
                if (nums[i1] < nums[i2]) {
                    tmp[index] = nums[i1];
                    i1++;
                } else {
                    tmp[index] = nums[i2];
                    i2++;
                }
            } else if (i1 <= end1) {
                tmp[index] = nums[i1];
                i1++;
            } else {
                tmp[index] = nums[i2];
                i2++;
            }
            index++;
        }

        index = 0;
        for (int i = beg1; i <= end2; i++) {
            nums[i] = tmp[index];
            index++;
        }
    }

    private static void merge2(int[] nums, int beg, int end) {
        int mid = (beg + end) / 2;
        int i1 = beg;
        int i2 = mid + 1;
        int[] tmp = new int[nums.length];
        int index = 0;
        while (i1 <= mid || i2 <= end) {
            if (i1 <= mid && i2 <= end) {
                if (nums[i1] < nums[i2]) {
                    tmp[index] = nums[i1];
                    i1++;
                } else {
                    tmp[index] = nums[i2];
                    i2++;
                }
            } else if (i1 <= mid) {
                tmp[index] = nums[i1];
                i1++;
            } else {
                tmp[index] = nums[i2];
                i2++;
            }
            index++;
        }

        index = 0;
        for (int i = beg; i <= end; i++) {
            nums[i] = tmp[index];
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,2,3,7,3,4,9,8};
        MergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
