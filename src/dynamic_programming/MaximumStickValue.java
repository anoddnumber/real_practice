package dynamic_programming;

public class MaximumStickValue {

    static int getMaxValueBruteForce(int length, int[] prices) {
        if (length <= 0) {
            return 0;
        }

        if (length == 1) {
            return prices[0];
        }

        int max = prices[length - 1];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, getMaxValueBruteForce(length - i, prices) + getMaxValueBruteForce(i, prices));
        }
        return max;
    }

    static int getMaxValueTopDown(int length, int[] prices) {
        int[] mem = new int[length];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
        return getMaxValueTopDown(length, prices, mem);
    }

    static int getMaxValueTopDown(int length, int[] prices, int[] mem) {
        if (length <= 0) {
            return 0;
        }

        if (length == 1) {
            return prices[0];
        }

        if (mem[length - 1] < 0) {
            int max = prices[length - 1];
            for (int i = 1; i < length; i++) {
                max = Math.max(max, getMaxValueTopDown(length - i, prices, mem) + getMaxValueTopDown(i, prices, mem));
            }
            mem[length - 1] = max;
        }

        return mem[length - 1];
    }

    static int getMaxValueBottomUp(int length, int[] prices) {
        int[] max_values = new int[length];
        max_values[0] = prices[0];

        for (int i = 1; i < length; i++) {
            int max = i < prices.length ? prices[i] : -1;

            for (int j = 0; j < i; j++) {
                max = Math.max(max, max_values[i - j - 1] + max_values[j]);
            }
            max_values[i] = max;
        }
        return max_values[length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {1,6,7,10,12,19,19};
        int length = 7;
        System.out.println(getMaxValueBruteForce(length, prices));
        System.out.println(getMaxValueTopDown(length, prices));
        System.out.println(getMaxValueBottomUp(length, prices));
    }
}
