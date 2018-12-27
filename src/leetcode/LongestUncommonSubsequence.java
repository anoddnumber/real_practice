package leetcode;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/
 */
public class LongestUncommonSubsequence {
    public int findLUSlength(String a, String b) {
        if (! a.equals(b)) {
            return a.length() > b.length() ? a.length() : b.length();
        }
        return -1;
    }
}
