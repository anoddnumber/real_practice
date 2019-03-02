package leetcode;

public class RotateString {

    public boolean rotateString(String A, String B) {
        /*
            Time Complexity - O(n ^ 2)
            Space Complexity - O(n)
         */
        if (A.length() != B.length()) return false;
        return (A + A).contains(B);
    }
}
