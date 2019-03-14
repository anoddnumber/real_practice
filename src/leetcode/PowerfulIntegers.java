package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        /*
            Time Complexity - O(bound)
            Space Complexity - O(1)
         */
        int xPow = 0;
        int yPow = 0;
        Set<Integer> ret = new HashSet<>();

        while ((int) Math.pow(x, xPow) + 1 <= bound) {
            int sum = (int) Math.pow(x, xPow) + (int) Math.pow(y, yPow);

            while (sum <= bound) {
                ret.add(sum);
                if (y == 1) break;
                yPow++;
                sum = (int) Math.pow(x, xPow) + (int) Math.pow(y, yPow);
            }
            if (x == 1) break;
            yPow = 0;
            xPow++;
        }

        return new LinkedList<>(ret);
    }

    public static void main(String[] args) {
        PowerfulIntegers p = new PowerfulIntegers();
        System.out.println(p.powerfulIntegers(2, 3, 10));
    }
}
