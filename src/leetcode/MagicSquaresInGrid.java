package leetcode;

import java.util.HashSet;

public class MagicSquaresInGrid {

    // this is a bad problem so i'm not going to put time/space complexities
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                count += isMagicSquaresInside(grid, i, j);
            }
        }
        return count;
    }

    public int isMagicSquaresInside(int[][] grid, int x, int y) {
        int sum = grid[x][y] + grid[x][y+1] + grid[x][y+2];
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[x+i][y+j];
                if (val < 1 || val > 9) return 0;
                if (s.contains(val)) return 0;
                s.add(val);
            }
        }

        if (sum == grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2] &&
            sum == grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2] &&
            sum == grid[x][y] + grid[x+1][y] + grid[x+2][y] &&
            sum == grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1] &&
            sum == grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2] &&
            sum == grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] &&
            sum == grid[x+2][y] + grid[x+1][y+1] + grid[x][y+2]

        ) {
            return 1;
        }
        return 0;
    }
}
