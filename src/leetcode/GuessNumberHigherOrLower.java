package leetcode;

//https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        /*
            Time Complexity - O(log(n))
            Space Complexity - O(1)
         */
        int hi = n;
        int lo = 1;
        int pick = (int) (((long) hi + lo) / 2);
        int res = guess(pick);

        while (res != 0) {
            if (res < 0) {
                hi = pick - 1;
            } else {
                lo = pick + 1;
            }
            pick = (int) (((long) hi + lo) / 2);
            res = guess(pick);
        }
        return pick;
    }

    int guess(int pick) {
        return -1; // this is defined by leetcode
    }

    public static void main(String[] args) {
        int test = (int) (((long) Integer.MAX_VALUE + Integer.MAX_VALUE) / 2);
        System.out.println("test: " + test);
    }
}
