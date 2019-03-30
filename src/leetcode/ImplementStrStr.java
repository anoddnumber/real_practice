package leetcode;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        /*
            Time Complexity - O(n * m) where n is the length of haystack and m is the length of needle
            Space Complexity - O(1)
         */
        if ("".equals(needle)) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
