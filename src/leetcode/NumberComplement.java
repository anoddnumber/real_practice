package leetcode;

/**
 * https://leetcode.com/problems/number-complement/
 */
public class NumberComplement {

    public int findComplement(int num) {
        /*
            Time Complexity - O(1)
            Space Complexity - O(1)
         */
        int msb = getNumberWithMostSignificantBitSet(num);
        int mask = msb - 1 | msb;
        return num ^ mask;
    }

    /**
     * https://www.geeksforgeeks.org/find-significant-set-bit-number/
     */
    public int getNumberWithMostSignificantBitSet(int n) {
        if (n >= 1 << 30) return 1 << 30;

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n + 1) >>> 1;
    }

    public static void main(String[] args) {
        NumberComplement n = new NumberComplement();

        // 10
        System.out.println(Integer.toBinaryString(n.findComplement(0b101)));

        // 1
        System.out.println(Integer.toBinaryString(n.findComplement(0b10)));

        // 111
        System.out.println(Integer.toBinaryString(n.findComplement(0b1000)));

        // 1000000000000000000
        System.out.println("2147483647: " + Integer.toBinaryString(n.findComplement(2147483647)));
        System.out.println("2147483647: " + n.findComplement(2147483647));
    }
}
