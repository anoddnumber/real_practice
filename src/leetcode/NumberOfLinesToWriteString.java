package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-lines-to-write-string/
 */
public class NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String S) {
        /*
            Time Complexity - O(n) where n is the number of characters in S
            Space Complexity - O(1)
         */
        if (S.length() == 0) {
            return new int[2];
        }
        int sum = 0;
        int numLines = 1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int width = widths[c - 'a'];

            if (sum + width > 100) {
                numLines++;
                sum = width;
            } else {
                sum += width;
            }
        }

        return new int[]{numLines, sum};
    }

    public static void main(String[] args) {
        NumberOfLinesToWriteString n = new NumberOfLinesToWriteString();

        int[] widths = {
            10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
        };

        // [3, 60]
        System.out.println(Arrays.toString(n.numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz")));

        int[] widths2 = {
                4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10
        };

        // [2, 4]
        System.out.println(Arrays.toString(n.numberOfLines(widths2, "bbbcccdddaaa")));
    }
}
