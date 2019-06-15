package dynamic_programming;

// https://www.techiedelight.com/longest-common-substring-problem/
public class LongestCommonSubstring {

    // bottom up
    static String longestCommonSubstring(String a, String b) {
        int[][] mem = new int[a.length() + 1][b.length() + 1];
        int max = 0;
        int lastIndex = 0;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    mem[i][j] = 1 + mem[i-1][j-1];
                    if (mem[i][j] > max) {
                        max = mem[i][j];
                        lastIndex = i;
                    }
                }
            }
        }
        return a.substring(lastIndex - max, lastIndex);
    }

    public static void main(String[] args)
    {
        String X = "ABCADE", Y = "BABCAIFDE";
        int m = X.length(), n = Y.length();

        // Find Longest common substring
        System.out.print("The Longest common substring is "
                + longestCommonSubstring(X, Y));
    }
}
