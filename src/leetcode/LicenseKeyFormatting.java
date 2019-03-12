package leetcode;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        /*
            Time Complexity - O(n) where n is the number of characters in S
            Space Compelxity - O(n)
         */
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }

            if (count == K) {
                sb.append('-');
                count = 0;
            }
            sb.append(Character.toUpperCase(c));
            count++;
        }
        return sb.reverse().toString();
    }

}
