package leetcode;

public class StudentAttendanceRecord1 {

    public boolean checkRecord(String s) {
        /*
            Time Complexity - O(n) where n is the number of characters in S
            Space Complexity - O(1)
         */
        boolean hasA = false;
        int numL = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (hasA) return false;
                hasA = true;
                numL = 0;
            } else if (c == 'L') {
                if (numL == 2) return false;
                numL++;
            } else {
                numL = 0;
            }
        }
        return true;
    }

}
