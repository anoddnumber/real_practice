package leetcode;

public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        /*
            Time Complexity - O(n) where n is the length of s
            Space Complexity - O(1)
         */
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return isPalindrome(s.substring(i, s.length() - 1 - i)) || isPalindrome(s.substring(i+1, s.length() - i));
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        if (s == null) return false;

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
