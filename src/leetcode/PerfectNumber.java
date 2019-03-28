package leetcode;

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        /*
            Time Complexity - O(num^(1/2))
            Space Complexity - O(1)
         */
        if (num <= 1) return false;

        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num && i != 1) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

}
