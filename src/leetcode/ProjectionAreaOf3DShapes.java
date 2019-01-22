package leetcode;

/**
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 */
public class ProjectionAreaOf3DShapes {


    /**
     * Looking from the top = # of non-zero values in the grid
     * Looking from the side = sum of the largest values in the rows
     * Looking from the front = sum of the largest values in the columns
     */
    public int projectionArea(int[][] grid) {
        /*
            Time Complexity = O(n^2) where n is the number of rows/columns
            Space Complexity = O(n)
            There is a way to make the space complexity O(1) if we don't use an array to store the maximum row and column values
            This can be done with still only 1 loop through the grid.
            This is done by computing the maximum column and row value in the inner loop (use [i][j] for the row and [j][i] for the column)
            And keep track of the sum in a single variable.
         */

        // Note: As in the problem description, we are assuming num rows == num cols
        if (grid.length == 0) {
            return 0;
        }

        int numTop = 0;
        int[] maxRowValues = new int[grid.length];
        int[] maxColValues = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            int maxRowVal = 0;
            for (int j = 0; j < grid.length; j++) {
                int val = grid[i][j];
                if (val != 0) {
                    numTop++;
                }

                if (val > maxRowVal) {
                    maxRowVal = val;
                }

                if (val > maxColValues[j]) {
                    maxColValues[j] = val;
                }
            }
            maxRowValues[i] = maxRowVal;
        }

        return numTop + sum(maxRowValues) + sum(maxColValues);
    }

    private int sum(int[] vals) {
        int sum = 0;
        for (int i = 0; i < vals.length; i++) {
            sum += vals[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ProjectionAreaOf3DShapes p = new ProjectionAreaOf3DShapes();
        // 8
//        int[][] grid = {
//            {1, 0},
//            {0, 2}
//        };

        // 14
//        int[][] grid = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };

        // 21
        int[][] grid = {
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2}
        };
        System.out.println(p.projectionArea(grid));
    }
}
