package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray {

    /**
     * Possible methods...
     * 1) square all the numbers and put it into a min/max heap then pull them out one at a time
     * 2) square all the numbers and then do an array sort
     * 3) 2 pointer method - 1 at the beginning and 1 at the end, check which number is bigger and put
     *    the square of the number into the rightmost value in the array.
     */
    public int[] sortedSquares(int[] A) {
        // we'll do method 3 (2 pointer method)
        // Time complexity is O(n)
        // Space complexity is O(n)
        // n = number of elements in A

        int sortedSquaresIndex = A.length - 1;
        int[] sortedSquares = new int[A.length];

        int frontIndex = 0;
        int backIndex = A.length - 1;

        while (frontIndex <= backIndex) {
            int front = A[frontIndex];
            int back = A[backIndex];

            int frontSquared = front * front;
            int backSquared = back * back;

            if (frontSquared > backSquared) {
                sortedSquares[sortedSquaresIndex] = frontSquared;
                frontIndex++;
            } else {
                sortedSquares[sortedSquaresIndex] = backSquared;
                backIndex--;
            }
            sortedSquaresIndex--;
        }
        return sortedSquares;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray s = new SquaresOfASortedArray();

//        int[] arr = {
//            -7,-3,2,3,11
//        };
        int[] arr = {
                -3,-3,-2,-1
        };
        System.out.println(Arrays.toString(s.sortedSquares(arr)));
    }
}
