package leetcode;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        /*
            Time Complexity - O(n + m) where n is the length of S and m is the length of T
            Space Complexity - O(n + m)
         */
        return processString(S).equals(processString(T));
    }

    public String processString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
