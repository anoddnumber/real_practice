package leetcode;

/**
 * https://leetcode.com/problems/flipping-an-image/
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            flip(A[i]);
            invert(A[i]);
        }
        return A;
    }

    public void flip(int[] A) {
        for (int i = 0; i < A.length / 2; i++) {
            swap(A, i, A.length - i - 1);
        }
    }

    public void swap(int[] A, int firstIndex, int secondIndex) {
        int tmp = A[firstIndex];
        A[firstIndex] = A[secondIndex];
        A[secondIndex] = tmp;
    }

    public void invert(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] ^= 1; // change 0 to 1 and vice versa
        }
    }

    public int[][] flipAndInvertImage2(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }

    public static void main(String[] args) {
        FlippingAnImage f = new FlippingAnImage();

//        int[][] twoDArray = {
//            {0, 0, 1},
//        };
//
//        print2DArray(twoDArray);
//        print2DArray(f.flipAndInvertImage(twoDArray));

        int[][] twoDArray2 = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0},
        };
        print2DArray(twoDArray2);
//        print2DArray(f.flipAndInvertImage(twoDArray2));

        print2DArray(f.flipAndInvertImage2(twoDArray2));
    }

    private static void print2DArray(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
