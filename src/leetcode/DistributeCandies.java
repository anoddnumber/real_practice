package leetcode;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        /*
            Time Complexity - O(n) where n is the number of candies
            Space Complexity - O(n)
         */
        Set<Integer> candiesTaken = new HashSet<>();

        int numTaken = 0;
        for (int candy : candies) {
            if (numTaken >= candies.length / 2) break;

            if (!candiesTaken.contains(candy)) {
                candiesTaken.add(candy);
                numTaken++;
            }
        }
        return candiesTaken.size();
    }

    public static void main(String[] args) {
        DistributeCandies d = new DistributeCandies();

        int[] candies = {1, 1, 2, 2, 3, 3};
        System.out.println(d.distributeCandies(candies)); // 3

        int[] candies2 = {1, 1, 2, 3};
        System.out.println(d.distributeCandies(candies2)); // 2

        int[] candies3 = {1, 2, 3};
        System.out.println(d.distributeCandies(candies3)); // 1
    }
}
