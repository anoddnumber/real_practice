package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/transpose-matrix/
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        /*
            Time complexity - O(r * c) where r = # of rows and c = # of columns
            Space complexity - O(r * c)
         */
        int[][] transposedMatrix = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transposedMatrix[j][i] = A[i][j];
            }
        }

        return transposedMatrix;
    }

    public static void main(String[] args) {
        TransposeMatrix t = new TransposeMatrix();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
        System.out.println(Arrays.deepToString(t.transpose(matrix)));

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
        };

        // [[1, 4], [2, 5], [3, 6]]
        System.out.println(Arrays.deepToString(t.transpose(matrix2)));
    }
}
