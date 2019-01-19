package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/di-string-match/
 */
public class DIStringMatch {

    public int[] diStringMatch(String S) {
        int numD = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                numD++;
            }
        }

        int[] permutation = new int[S.length() + 1];
        permutation[0] = numD;

        int iNumber = numD + 1;
        int dNumber = numD - 1;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                permutation[i + 1] = iNumber;
                iNumber++;
            } else {
                permutation[i + 1] = dNumber;
                dNumber--;
            }
        }

        return permutation;
    }



    public static void main(String[] args) {
        DIStringMatch d = new DIStringMatch();

        String str = "DDI";
        System.out.println(Arrays.toString(d.diStringMatch(str)));
    }
}
