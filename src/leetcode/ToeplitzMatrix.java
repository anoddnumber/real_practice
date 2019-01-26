package leetcode;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        /*
            Time Complexity - O(m * n) where m = the number of rows and n = number of columns in the matrix
            Space Complexity - O(1)
         */
        if (matrix.length <= 1 || matrix[0].length <= 1) {
            return true;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (!isToeplitzDiagonal(matrix, i, 0)) {
                return false;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (!isToeplitzDiagonal(matrix, 0, j)) {
                return false;
            }
        }

        return true;
    }

    public boolean isToeplitzDiagonal(int[][] matrix, int row, int col) {
        if (matrix.length <= 0 || matrix.length < row || matrix[0].length < col) {
            return true;
        }

        int num = matrix[row][col];
        int j = col;
        for (int i = row; i < matrix.length; i++) {
            if (j >= matrix[0].length) {
                break;
            }
            if (matrix[i][j] != num) {
                return false;
            }
            j++;
        }
        return true;
    }
}
