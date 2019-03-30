package leetcode;

public class Sqrt {

    public int mySqrt(int x) {
        /*
            Time Complexity - O(n ^ (1/2))
            Space Complexity - O(1)
         */
        int ret = 0;
        for (long i = 0; i * i <= x; i++) {
            ret = (int) i;
        }
        return ret;
    }
}
