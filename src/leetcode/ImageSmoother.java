package leetcode;

public class ImageSmoother {

    int count = 0;

    public int[][] imageSmoother(int[][] M) {
        /*
            Time Complexity - O(n * m) where n is the number of rows and m is the number of columns in M
            Space Complexity - O(n * m) for the new int[][]
         */
        int[][] ret = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                count = 0;
                ret[i][j] = greyScale(M, i, j);
            }
        }
        return ret;
    }

    int greyScale(int[][] M, int i, int j) {
        int sum = 0;

        //left
        sum += add(M, i - 1, j - 1);
        sum += add(M, i, j - 1);
        sum += add(M, i + 1, j - 1);

        // middle
        sum += add(M,i-1, j);
        sum += add(M, i, j);
        sum += add(M,i+1, j);

        // right
        sum += add(M, i - 1, j + 1);
        sum += add(M,i, j + 1);
        sum += add(M, i + 1, j + 1);

        return sum / count;
    }

    int add(int[][] M, int i, int j) {
        if (i >= 0 && i < M.length && j >= 0 && j < M[0].length) {
            count++;
            return M[i][j];
        }
        return 0;
    }
}
