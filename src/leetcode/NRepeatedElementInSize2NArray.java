package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class NRepeatedElementInSize2NArray {

    /**
     * Return the element that has more than 1 instance of it
     * Iterate through the array, store each element into a Set if it is not in the Set already
     * If the element is already in the Set, return that value
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     *
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        Set s = new HashSet();
        for (int i = 0; i < A.length; i++) {
            int e = A[i];
            if (s.contains(e)) {
                return e;
            }
            s.add(e);
        }
        return -1;
    }

    /**
     * This time, we take advantage of knowing that an element is repeated n times in the array (the major element) even more.
     * The major element must appear in at least 1 sub array of length 3 twice (except for the case of n = 2, where there are 4 elements).
     * Therefore, when we loop through the array, we can simply compare the current element with the next 2 elements to check for a duplicate.
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * @param A
     * @return
     */
    public int repeatedNTimes2(int[] A) {
        if (A.length == 4) {
            if (A[0] == A[1]) return A[0];
            if (A[0] == A[2]) return A[0];
            if (A[0] == A[3]) return A[0];
            if (A[1] == A[2]) return A[1];
            if (A[1] == A[3]) return A[1];
            return A[2];
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < A.length - i; j++) {
                if (A[j] == A[j+i]) return A[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NRepeatedElementInSize2NArray a = new NRepeatedElementInSize2NArray();
        System.out.println(a.repeatedNTimes(new int[] {2,3,3,1})); // 3
        System.out.println(a.repeatedNTimes(new int[] {2,1,2,5,3,2})); // 2
        System.out.println(a.repeatedNTimes(new int[] {5,1,5,2,5,3,5,4})); // 5
        System.out.println(a.repeatedNTimes2(new int[] {2,3,3,1})); // 3
        System.out.println(a.repeatedNTimes2(new int[] {2,1,2,5,3,2})); // 2
        System.out.println(a.repeatedNTimes2(new int[] {5,1,5,2,5,3,5,4})); // 5
    }
}
