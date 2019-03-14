package leetcode;

public class IsPowerOfFour {

    public boolean isPowerOfFour(int num) {
        /*
            Time Complexity - O(1)
            Space Complexity - O(1)
         */
        int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt != num) return false;

        //now check if sqrt is a power of 2
        return num != 0 && (sqrt & (sqrt - 1)) == 0;
    }
}
