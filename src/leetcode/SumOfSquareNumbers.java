package leetcode;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        /*
            Time Complexity - O(c^(1/2) * log(c))
            Space Complexity - O(1)
         */
        if (c < 0) return false;

        for (long i = 0; i * i <= c; i++) {
            int c2 = (int) (c - i * i);

            double c3 = Math.sqrt(c2);
            if (c3 == (int) c3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        System.out.println(s.judgeSquareSum(2147483646));
    }
}
