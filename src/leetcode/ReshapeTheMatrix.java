package leetcode;

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        /*
            Time Complexity - O(n * m) where n is the number of rows and m is the number of columns
            Space Complexity - O(n * m) for the new matrix
         */
        if (nums.length <= 0 || nums[0].length <= 0) return nums;

        if (nums.length * nums[0].length != r * c) return nums;

        int[][] newMatrix = new int[r][c];

        int rowIndex = 0;
        int colIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                newMatrix[rowIndex][colIndex] = nums[i][j];

                colIndex++;
                if (colIndex >= c) {
                    colIndex = 0;
                    rowIndex++;
                }
            }
        }

        return newMatrix;
    }
}
