package leetcode;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        /*
            Time Complexity - O(n ^ 2) where n is the number of characters in s
            Space Complexity - O(1)
         */
        if (s == null || s.length() <= 1) return false;

        for (int i = 1; i < s.length(); i+=2) {
            if (isRepeatable(s, i)) {
                return true;
            }
        }
        return isRepeatable(s, 2);
    }

    private boolean isRepeatable(String s, int numCharRepeated) {
        if (s == null || s.length() % numCharRepeated != 0 || numCharRepeated <= 0) return false;

        int index1 = 0;
        int index2 = numCharRepeated == 1 ? 1 : s.length() / numCharRepeated;

        while (index2 < s.length()) {
            if (s.charAt(index1) != s.charAt(index2)) {
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }

}
