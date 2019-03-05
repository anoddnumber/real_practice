package leetcode;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        /*
            Time Complexity - O(n) where n is the number of characters in s
            Space Complexity - O(1) (or O(m) where m is the number of possible characters)
         */
        // yes, i know i'm wasting 6 slots of "int"...just did not want to do the extra checks for lowercase vs uppercase letters
        int[] counts = new int[58];
        int longestPalindrome = 0;
        int numOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'A';
            counts[index]++;
            if ((counts[index] & 1) == 0) {
                longestPalindrome += 2;
                numOdd--;
            } else {
                numOdd++;
            }
        }
        return numOdd > 0 ? longestPalindrome + 1 : longestPalindrome;
    }

}
