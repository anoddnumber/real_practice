package leetcode;

public class AddBinary {

    public String addBinary(String a, String b) {
        /*
            Time Complexity - O(n + m) where n and m are the length of a and b respectively
            Space Complexity - O(n + m)
         */
        StringBuilder sb = new StringBuilder();

        int pos = 0;

        int aIndex = a.length() - pos - 1;
        int bIndex = b.length() - pos - 1;

        Character ca = aIndex >= 0 ? a.charAt(a.length() - pos - 1) : null;
        Character cb = bIndex >= 0 ? b.charAt(b.length() - pos - 1) : null;
        boolean carry = false;

        while (ca != null || cb != null) {
            if (ca == null) {
                if (carry && cb == '1') {
                    sb.append('0');
                } else if (carry && cb == '0') {
                    sb.append('1');
                    carry = false;
                } else if (!carry && cb == '1') {
                    sb.append('1');
                    carry = false;
                } else {
                    sb.append('0');
                    carry = false;
                }
            } else if (cb == null) {
                if (carry && ca == '1') {
                    sb.append('0');
                } else if (carry && ca == '0') {
                    sb.append('1');
                    carry = false;
                } else if (!carry && ca == '1') {
                    sb.append('1');
                    carry = false;
                } else {
                    sb.append('0');
                    carry = false;
                }
            } else {
                if (carry && ca == '1' && cb == '1') {
                    sb.append('1');
                } else if (carry && ca == '1' && cb == '0') {
                    sb.append('0');
                } else if (carry && ca == '0' && cb == '1') {
                    sb.append('0');
                } else if (carry && ca == '0' && cb == '0') {
                    sb.append('1');
                    carry = false;
                } else if (!carry && ca == '1' && cb == '1') {
                    sb.append('0');
                    carry = true;
                } else if (!carry && ca == '1' && cb == '0') {
                    sb.append('1');
                    carry = false;
                } else if (!carry && ca=='0' && cb == '1') {
                    sb.append('1');
                } else if (!carry && ca == '0' && cb == '0') {
                    sb.append('0');
                }
            }
            pos++;

            aIndex = a.length() - pos - 1;
            bIndex = b.length() - pos - 1;

            ca = aIndex >= 0 ? a.charAt(a.length() - pos - 1) : null;
            cb = bIndex >= 0 ? b.charAt(b.length() - pos - 1) : null;
        }
        if (carry) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

}
