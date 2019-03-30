package leetcode;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        /*
            Time Complexity - O((a + b) * b) where a is the length of A and b is the length of B
            Space Complexity - O(a + b)
         */
        int count = 1;
        String C = A;
        if (A.length() < B.length()) {
            StringBuilder sb = new StringBuilder(A);
            while (sb.length() < B.length()) {
                sb.append(A);
                count++;
            }
            C = sb.toString();
        }

        if (C.indexOf(B) >= 0) {
            return count;
        }

        if ((C + A).indexOf(B) >= 0) {
            return count + 1;
        }

        return -1;
    }
}
