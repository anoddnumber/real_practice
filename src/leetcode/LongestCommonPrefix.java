package leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        /*
            Time Complexity - O(n * m) where n is the length of strs and m is the length of the shortest word in strs
            Space Complexity - O(1)
         */
        if (strs.length <= 0) return "";

        int index = 0;
        StringBuilder ret = new StringBuilder();

        while (true) {
            if (strs[0].length() < index + 1) {
                return ret.toString();
            }

            char c = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                String s = strs[i];
                if (s.length() < index + 1 || c != s.charAt(index)) {
                    return ret.toString();
                }
            }
            ret.append(c);
            index++;
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"abcd", "abcd", "abcc"}));
    }
}
