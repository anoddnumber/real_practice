package leetcode;

import java.util.HashMap;

/*
    https://leetcode.com/problems/range-sum-query-immutable/
 */
public class NumArray {
    /*
        Second attempt
        Time Complexity - O(n) for precomputation where n is the length of nums
        Space Complexity - O(n)
     */
    int[] sum;

    public NumArray(int[] nums) {
        this.sum = new int[nums.length];
        int sumSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            this.sum[i] = sumSoFar;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return this.sum[j];
        return this.sum[j] - this.sum[i - 1];
    }
}

//public class NumArray {
//    /*
//        First Attempt
//     */
//    int[] numbers;
//    HashMap<Range, Integer> map = new HashMap<>();
//
//    class Range {
//        int start, end;
//
//        public Range(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            return o instanceof Range && this.start == ((Range) o).start && this.end == ((Range) o).end;
//        }
//
//        public int hashCode() {
//            return start * 2 + end * 2;
//        }
//
//    }
//
//    public NumArray(int[] nums) {
//        this.numbers = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        /*
//            First attempt...too slow
//         */
//        if (i > j || i < 0 || j >= this.numbers.length) return 0;
//        if (i == j) {
//            return this.numbers[i];
//        }
//        Range r = new Range(i, j);
//        if (this.map.containsKey(r)) {
//            return this.map.get(r);
//        }
//
//        int midPoint = (int) ((long) i + j) / 2;
//        int sum = sumRange(i, midPoint) + sumRange(midPoint + 1, j);
//        this.map.put(r, sum);
//        return sum;
//    }
//
//    public static void main(String[] args) {
//
//        NumArray n = new NumArray(new int[]{1,2,3,4});
//        System.out.println(n.sumRange(0, 3));
////        System.out.println(n.sumRange(0, 3));
////        System.out.println(n.sumRange(0, 3));
////        System.out.println(n.sumRange(0, 3));
////        System.out.println(n.sumRange(0, 3));
////        System.out.println(n.sumRange(0, 3));
//    }
//}
