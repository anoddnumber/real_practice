package leetcode;

import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        /*
            Time Complexity - O(m) where m is the number of cycles until a repeated number (not sure how to calculate..)
            Space Complexity - O(m)
         */
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNewNumber(n);
        }
        return true;
    }

    int getNewNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

}
