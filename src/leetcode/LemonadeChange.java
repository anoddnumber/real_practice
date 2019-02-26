package leetcode;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        /*
            Time Complexity - O(n) where n is the length of bills
            Space Complexity - O(1)
         */
        // The 0th index represents $5 bills
        // The 1st index represents $10 bills
        int[] change = {0, 0};
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                change[0]++;
            } else if (bill == 10) {
                if (change[0] <= 0) return false;
                change[0]--;
                change[1]++;
            } else if (bill == 20) {
                if (change[0] > 0 && change[1] > 0) {
                    change[0]--;
                    change[1]--;
                } else if (change[0] >= 3) {
                    change[0] -= 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
