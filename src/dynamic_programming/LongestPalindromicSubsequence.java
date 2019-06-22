package dynamic_programming;

import utils.Utils;

import java.util.Arrays;
import java.util.Stack;

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

    static String getLongestPalindromicSubsequence(String s) {
        int[][] mem = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            mem[i][i] = 1;
        }

        for (int max = 1; max < s.length(); max++) {
            for (int min = max - 1; min >= 0; min--) {
                char minChar = s.charAt(min);
                char maxChar = s.charAt(max);

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

        return getLongestPalindromicSubsequenceForColumn(s, mem, s.length() - 1);
    }

    static String getLongestPalindromicSubsequenceForColumn(String s, int[][] mem, int col) {
        if (col >= mem.length) return "";
        if (s.length() == 1) return s;

        boolean isEven = mem[0][col] % 2 == 0;
        String str = "";
        Stack<Character> stack = new Stack<>();

        for (int row = 0; row < mem[col].length - 1; row++) {
            if (mem[row][col] == 0) {
                break;
            }

            int cur = mem[row][col];
            int next = mem[row + 1][col];

            if (cur != next) {
                stack.push(s.charAt(row));
            }

            if (next == 1) {
                if (!isEven) {
                    str = "" + s.charAt(row + 1);
                }

                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    str = c + str + c;
                }
                break;
            }
        }
        return str;
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

        Utils.print2DArray(mem);

        return mem[0][a.length() - 1];
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindromicSubsequence("ABBDCACBFHSKDJFHSKDJFHFHFHDJFHS"));
//        System.out.println(longestPalindromicSubsequence2("ABBDCACBFHSKDJFHSKDJFHFHFHDJFHS"));

        String abc = "ASDBBAU";
//        String abc = "ABBDCACBFHSKDJFHSKDJFHFHFHDJFHS";
        System.out.println(longestPalindromicSubsequence(abc));
//        System.out.println(longestPalindromicSubsequence2(abc));

        String longestPalindromSubsequence = getLongestPalindromicSubsequence(abc);
        System.out.println(longestPalindromSubsequence);
        System.out.println("length: " + longestPalindromSubsequence.length());
    }
}