package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        /*
            Time Complexity - O(n * m) where n is the length of A and m is the length of B
            Space Complexity - O(1)

            We can decrease the time complexity (and increase the Space Complexity) if we use a Set to contain all the elements of B (or A)
         */
        int sumA = IntStream.of(A).sum();
        int sumB = IntStream.of(B).sum();

        int distance = (sumA - sumB) / 2;
        return candySwap(A, B, distance);
    }

    public int[] candySwap(int[] A, int[] B, int distance) {
        int a=0;
        int b=0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == distance) {
                    a = A[i];
                    b = B[j];
                    break;
                }
            }
        }
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1};
        int[] B = new int[]{2, 2};

        FairCandySwap f = new FairCandySwap();
        System.out.println(Arrays.toString(f.fairCandySwap(A, B))); // [1, 2]

        int[] A2 = new int[]{2, 1};
        int[] B2 = new int[]{2, 3};

        System.out.println(Arrays.toString(f.fairCandySwap(A2, B2))); // [1, 2]

        int[] A3 = new int[]{2};
        int[] B3 = new int[]{1, 3};

        System.out.println(Arrays.toString(f.fairCandySwap(A3, B3))); // [2, 3]

        int[] A4 = new int[]{2, 1, 5};
        int[] B4 = new int[]{2, 4};

        System.out.println(Arrays.toString(f.fairCandySwap(A4, B4))); // [5, 4]


    }
}
