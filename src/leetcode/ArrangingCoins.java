package leetcode;

public class ArrangingCoins {

    /*
        1 + 2 + ... + x <= n
        x ( x + 1) / 2 <= n
     */
    public int arrangeCoins(int n) {
        /*
            Time Complexity - O(log(n))
            Space Complexity - O(1)
         */
        int lo = 0;
        int hi = n;

        while (lo <= hi) {
            int pick = (int) (((long) lo + hi) / 2);
            long result = ((long) pick * (pick + 1)) / 2;
            if (result < n) {
                if (n - result < pick + 1) {
                    return pick;
                }
                lo = pick + 1;
            } else if (result == n) {
                return pick;
            } else {
                hi = pick - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrangingCoins a = new ArrangingCoins();
//        System.out.println(a.arrangeCoins(8));
        System.out.println(a.arrangeCoins(Integer.MAX_VALUE));
    }
}
