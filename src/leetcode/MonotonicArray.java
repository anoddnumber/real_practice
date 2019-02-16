package leetcode;

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        /*
            Time Complexity - O(n) where n is the number of elements in A
            Space Complexity - O(1)
         */
        if (A.length <= 1) return true;

        boolean isSet = false; // set to true once we know if it is increasing or decreasing
        boolean isIncreasing = false;

        for (int i = 1; i < A.length; i++) {
            if (isSet) {
                if (isIncreasing && A[i-1] > A[i]) return false;
                if (!isIncreasing && A[i-1] < A[i]) return false;
            } else {
                if (A[i-1] < A[i]) {
                    isSet = true;
                    isIncreasing = true;
                } else if (A[i-1] > A[i]) {
                    isSet = true;
                    isIncreasing = false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray m = new MonotonicArray();
        System.out.println(m.isMonotonic(new int[]{1,2,3,4})); // true
        System.out.println(m.isMonotonic(new int[]{4,3,2,1})); // true
        System.out.println(m.isMonotonic(new int[]{4,3,1,2})); // false
        System.out.println(m.isMonotonic(new int[]{1,1,2})); // true
    }
}
