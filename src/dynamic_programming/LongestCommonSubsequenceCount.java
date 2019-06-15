package dynamic_programming;

// https://www.techiedelight.com/longest-common-subsequence/
public class LongestCommonSubsequenceCount {

    static int[][] mem;

    // top down
    int longestCommonSubsequence(String x, String y, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (mem[m][n] == 0) {
            char cx = x.charAt(m);
            char cy = y.charAt(n);
            if (cx == cy) {
                mem[m][n] = longestCommonSubsequence(x, y, m - 1, n - 1) + 1;
            } else {
                mem[m][n] = Math.max(
                        longestCommonSubsequence(x, y, m, n - 1),
                        longestCommonSubsequence(x, y, m - 1, n)
                );
            }
        }

        return mem[m][n];
    }

    static int[][] mem2;

    // bottom up
    int longestCommonSubsequence2(String x, String y) {
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                char cx = x.charAt(i - 1);
                char cy = y.charAt(j - 1);

                if (cx == cy) {
                    mem2[i][j] = mem2[i-1][j-1] + 1;
                } else {
                    mem2[i][j] = Math.max(mem2[i-1][j], mem2[i][j-1]);
                }
            }
        }
        return mem2[x.length()][y.length()];
    }

    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";
        mem = new int[x.length()][y.length()];
        mem2 = new int[x.length() + 1][y.length() + 1];
        LongestCommonSubsequenceCount l = new LongestCommonSubsequenceCount();
        System.out.println(l.longestCommonSubsequence(x, y, x.length() - 1, y.length() - 1));
        System.out.println(l.longestCommonSubsequence2(x, y));
    }
}
