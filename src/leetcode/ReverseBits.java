package leetcode;

public class ReverseBits {

    public int reverseBits(int n) {
        /*
            Time Complexity - O(1)
            Space Complexity - O(1)
         */
        int newInt = 0;

        for (int i = 0; i < 32; i++) {
            newInt = newInt << 1;
            newInt = newInt | n & 1;
            n = n >> 1;
        }

        return newInt;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        int test = 43261596;
        System.out.println(Integer.toBinaryString(test));
        System.out.println(Integer.toBinaryString(r.reverseBits(test)));
    }
}