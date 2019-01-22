package leetcode;

/**
 * https://leetcode.com/problems/smallest-range-i/
 */
public class SmallestRange1 {

    /**
     * Find the largest element and the smallest element in the array.
     * Subtract K from the largest element and add K to the smallest element
     * if the largest element is smaller than the smallest element now, return 0
     * otherwise return the difference between them
     */
    public int smallestRangeI(int[] A, int K) {
        /*
            Time complexity - O(n) where n is the length of A
            Space complexity - O(1)
         */
        int min = -1;
        int max = -1;

        for (int i = 0; i < A.length; i++) {
            if (max == -1 || A[i] > max) {
                max = A[i];
            }

            if (min == -1 || A[i] < min) {
                min = A[i];
            }
        }

        if (max - K < min + K) {
            return 0;
        }

        return max - K - min - K;
    }

    public static void main(String[] args) {
        SmallestRange1 s = new SmallestRange1();

        int[] arr = {1};
        System.out.println(s.smallestRangeI(arr, 0)); // 0

        int[] arr2 = {0, 10};
        System.out.println(s.smallestRangeI(arr2, 2)); // 6

        int[] arr3 = {1, 3, 6};
        System.out.println(s.smallestRangeI(arr3, 3)); // 0
    }
}
