package leetcode;

public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        boolean prev = (n & 1) == 1 ? false : true; // represents if the previous bit was set
        while (n > 0) {
            if (prev && (n & 1) == 1 || !prev && (n & 1) == 0) {
                return false;
            }

            prev = ! prev;
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits b = new BinaryNumberWithAlternatingBits();
        System.out.println(b.hasAlternatingBits(5)); //true
        System.out.println(b.hasAlternatingBits(7)); //false
        System.out.println(b.hasAlternatingBits(11)); //false
        System.out.println(b.hasAlternatingBits(10)); //true
        System.out.println(b.hasAlternatingBits(4)); //false
    }
}
