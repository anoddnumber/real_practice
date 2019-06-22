package dynamic_programming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    // top down
    static int longestPalindromicSubsequence(String a) {
        int[][] mem = new int[a.length()][a.length()];
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                mem[i][j] = -1;
            }
        }

        return longestPalindromicSubsequence(a, 0, a.length() - 1, mem);
    }

    // top down
    static int longestPalindromicSubsequence(String a, int min, int max, int[][] mem) {
        if (min < 0 || max < 0 || min >= a.length() || max >= a.length() || min > max) {
            return 0;
        }

        if (min == max) {
            return 1;
        }

        if (mem[min][max] == -1) {
            if (a.charAt(min) == a.charAt(max)) {
                mem[min][max] = 2 + longestPalindromicSubsequence(a, min + 1, max - 1, mem);
            } else {
                mem[min][max] = Math.max(
                    longestPalindromicSubsequence(a, min + 1, max, mem),
                    longestPalindromicSubsequence(a, min, max - 1, mem)
                );
            }
        }

        return mem[min][max];
    }

    // bottom up
    static int longestPalindromicSubsequence2(String a) {
        int[][] mem = new int[a.length()][a.length()];

        for (int i = 0; i < a.length(); i++) {
            mem[i][i] = 1;
        }

        for (int max = 1; max < a.length(); max++) {
            for (int min = max - 1; min >= 0; min--) {
                char minChar = a.charAt(min);
                char maxChar = a.charAt(max);

                int count = 0;
                if (minChar == maxChar) {
                    count += 2;
                    if (min + 1 <= max - 1) {
                        count += mem[min + 1][max - 1];
                    }
                } else {
                    int moveMinCount = 0;
                    int moveMaxCount = 0;

                    if (min + 1 <= max) {
                        moveMinCount = mem[min + 1][max];
                    }

                    if (min <= max - 1) {
                        moveMaxCount = mem[min][max - 1];
                    }

                    count = Math.max(moveMinCount, moveMaxCount);
                }
                mem[min][max] = count;
            }
        }

        return mem[0][a.length() - 1];
    }

//    min = 2, max = 4

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubsequence("ABBDCACBFHSKDJFHSKDJFHFHFHDJFHS"));
        System.out.println(longestPalindromicSubsequence2("ABBDCACBFHSKDJFHSKDJFHFHFHDJFHS"));

//        String abc = "HJFFHJ";
//        System.out.println(longestPalindromicSubsequence(abc));
//        System.out.println(longestPalindromicSubsequence2(abc));
    }
}
