package leetcode;

public class BinaryGap {
    public int binaryGap(int N) {
        /*
            Time Complexity - O(n) where n is the number of bits in the number (a java int has 32 bits)
            Space Complexity - O(n), the string we convert the number to will have n number of characters
         */
        String s = Integer.toBinaryString(N);

        int prevIndex = 0;
        int diff = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                diff = Math.max(i - prevIndex, diff);
                prevIndex = i;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        BinaryGap b = new BinaryGap();
        System.out.println(b.binaryGap(22)); // 2
    }
}
