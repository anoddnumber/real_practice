package leetcode;

import java.util.HashSet;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        /*
            Time Complexity - O(n) where n is the length of A
            Space Complexity - O(n)
         */
        if (A.length() != B.length()) return false;

        if (A.equals(B)) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                char c = A.charAt(i);
                if (set.contains(c)) return true;
                set.add(c);
            }
            return false;
        }

        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < A.length(); i++) {
            char ca = A.charAt(i);
            char cb = B.charAt(i);

            if (ca != cb) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1) {
                    index2 = i;
                    break;
                }
            }
        }

        if (index1 == -1 || index2 == -1) {
            return false;
        }

        String str2 = new String(swap(A, index1, index2));
        return str2.equals(B);
    }

    static char[] swap(String str, int i, int j)
    {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }
}
