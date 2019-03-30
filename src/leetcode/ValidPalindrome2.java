package leetcode;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome2 {

    public boolean isPalindrome(String s) {
        /*
            Time Complexity - O(n) where n is the length of s
            Space Complexity - O(1)
         */
        int lo = 0;
        int hi = s.length() - 1;

        while (lo < hi) {
            while (lo < hi && !isValidChar(s.charAt(lo))) {
                lo++;
            }

            if (lo >= hi) {
                break;
            }

            while (lo < hi && !isValidChar(s.charAt(hi))) {
                hi--;
            }

            if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) {
                return false;
            }
            lo++;
            hi--;
        }

        return true;
    }

    private boolean isValidChar(char c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }
}
