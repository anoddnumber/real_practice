package leetcode;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        /*
            Time Complexity - O(log(n))
            Space Complexity - O(1)
         */
        int res = 0;
        for (int i = 1; i < n; i++) {
            double pow = Math.pow(5, i);
            if (pow > n) {
                break;
            }
            res += n / pow;
        }
        return res;
    }
}
