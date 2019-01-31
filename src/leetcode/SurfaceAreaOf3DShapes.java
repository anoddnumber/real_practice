package leetcode;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/discuss/163414/C%2B%2BJava1-line-Python-Minus-Hidden-Area
 */
public class SurfaceAreaOf3DShapes {

    public int surfaceArea(int[][] grid) {
        /*
            Time Complexity - O(n^2) where n is the number of rows (also is the number of columns)
            Space Complexity - O(1)
         */
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += surfaceArea(grid, i, j);
            }
        }
        return sum;
    }

    public int surfaceArea(int[][] grid, int row, int col) {
        int numCubes = grid[row][col];
        if (numCubes <= 0) {
            return 0;
        }
        int surfaceArea = numCubes * 4 + 2; // 4 per cube and 2 for the top and bottom

        //subtract off any surface area if they are blocked on the left/right/up/down

        int surfaceCovered = 0;

        // left
        if (col - 1 >= 0) {
            if (grid[row][col - 1] > numCubes) {
                surfaceCovered += numCubes;
            } else {
                surfaceCovered += grid[row][col - 1];
            }
        }

        // right
        if (col + 1 < grid[0].length) {
            if (grid[row][col + 1] > numCubes) {
                surfaceCovered += numCubes;
            } else {
                surfaceCovered += grid[row][col + 1];
            }
        }

        // up
        if (row - 1 >= 0) {
            if (grid[row - 1][col] > numCubes) {
                surfaceCovered += numCubes;
            } else {
                surfaceCovered += grid[row - 1][col];
            }
        }

        // down
        if (row + 1 < grid.length) {
            if (grid[row + 1][col] > numCubes) {
                surfaceCovered += numCubes;
            } else {
                surfaceCovered += grid[row + 1][col];
            }
        }

        return surfaceArea - surfaceCovered;
    }

    public static void main(String[] args) {
        SurfaceAreaOf3DShapes s = new SurfaceAreaOf3DShapes();

        int[][] grid = {
                {2}
        };
        System.out.println(s.surfaceArea(grid)); // 10

        int[][] grid2 = {
                {1, 2},
                {3, 4},
        };

        System.out.println(s.surfaceArea(grid2)); // 34

        int[][] grid3 = {
                {1, 0},
                {0, 2},
        };

        System.out.println(s.surfaceArea(grid3)); // 16

        int[][] grid4 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        System.out.println(s.surfaceArea(grid4)); // 32

        int[][] grid5 = {
                {2, 2, 2},
                {2, 1, 2},
                {2, 2, 2},
        };

        System.out.println(s.surfaceArea(grid5)); // 46
    }
}
