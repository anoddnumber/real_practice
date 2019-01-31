package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle
 */
public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] A) {
        /*
            Time Complexity - O(nlogn) where n is the length of the array
            Space Complexity - O(1)
         */
        if (A.length < 2) return 0;

        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle l = new LargestPerimeterTriangle();
        System.out.println(l.largestPerimeter(new int[] {2, 1, 2})); // 5
        System.out.println(l.largestPerimeter(new int[] {1, 2, 1})); // 0
        System.out.println(l.largestPerimeter(new int[] {3, 2, 3, 4})); // 10
        System.out.println(l.largestPerimeter(new int[] {3, 6, 2, 3})); // 8
    }
}
