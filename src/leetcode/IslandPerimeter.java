package leetcode;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        /*
            Time Complexity - O(n x m) where n is the number of rows and m is the number of columns
            Space Complexity - O(n x m) since it is possible that the stack size can be equal to the entire matrix
         */
        if (grid.length <= 0 || grid[0].length <= 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return islandPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int islandPerimeter(int[][] grid, int row, int col) {
        if (grid.length <= 0 || grid.length <= row || grid[0].length <= col || row < 0 || col < 0) return 1;
        System.out.println("row: " + row);
        System.out.println("col: " + col);
        if (grid[row][col] == -1) return 0;
        if (grid[row][col] == 0) return 1;

        grid[row][col] = -1; // mark this part of the grid as seen

        int perimeter = 0;
        //check up
        perimeter += islandPerimeter(grid, row, col - 1);

        //check down
        perimeter += islandPerimeter(grid, row, col + 1);

        //check left
        perimeter += islandPerimeter(grid, row - 1, col);

        //check right
        perimeter += islandPerimeter(grid, row + 1, col);

        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter is = new IslandPerimeter();

        int[][] grid = {{1}, {0}};
        System.out.println(is.islandPerimeter(grid));
    }
}
