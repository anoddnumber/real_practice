package leetcode;

public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        /*
            Time Complexity - O(n) where n is the length of A
            Space Complexity - O(1)
         */
        if (A.length < 3) return false;
        if (A[0] >= A[1]) return false;

        int index = 0;
        while (index < A.length - 1 && A[index] < A[index + 1]) {
            index++;
        }

        if (index >= A.length - 1) return false;

        while (index < A.length - 1) {
            if (A[index] <= A[index + 1]) return false;
            index++;
        }
        return true;
    }
}
