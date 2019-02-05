package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        /*
            Time Complexity - O(2 ^ n) where n is the number of characters in S
            Space Complexity - O(n) for the stack space
         */
        if (S.length() <= 0) {
            List<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }

        if (S.length() == 1) {
            List<String> ret = new ArrayList<>();
            char c = S.charAt(0);
            ret.add(S);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    ret.add(String.valueOf(Character.toUpperCase(c)));
                } else {
                    ret.add(String.valueOf(Character.toLowerCase(c)));
                }
            }

            return ret;
        }

        List<String> ret = letterCasePermutation(S.substring(1));

        char c = S.charAt(0);
        if (Character.isLetter(c)) {
            List<String> ret2 = new LinkedList<>(ret);
            appendToFront(Character.toLowerCase(c), ret);
            appendToFront(Character.toUpperCase(c), ret2);
            ret.addAll(ret2);
        } else {
            appendToFront(c, ret);
        }

        return ret;
    }

    public void appendToFront(char c, List<String> l) {
        for (int i = 0; i < l.size(); i++) {
            l.add(i, c + l.remove(i));
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        System.out.println(l.letterCasePermutation("ab3c"));
    }
}
