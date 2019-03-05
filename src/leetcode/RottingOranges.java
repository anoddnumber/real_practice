package leetcode;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        /*
            Time Complexity - O(n * m * max(n, m)) where n and m are the number of rows and columns in grid
            Space Complexity - O(1)
         */
        int count = 0;
        while (markRottingOranges(grid)) {
            changeToRottingOranges(grid);
            count++;
        }
        if (hasFreshOranges(grid)) {
            return -1;
        }

        return count;
    }

    boolean hasFreshOranges(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean markRottingOranges(int[][] grid) {
        boolean hasFresh = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    hasFresh |= markRotten(grid, i - 1, j);
                    hasFresh |= markRotten(grid, i + 1, j);
                    hasFresh |= markRotten(grid, i, j - 1);
                    hasFresh |= markRotten(grid, i, j + 1);
                }
            }
        }
        return hasFresh;
    }

    boolean markRotten(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = -2;
            return true;
        }
        return false;
    }

    private void changeToRottingOranges(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = 2;
                }
            }
        }
    }
}
