package leetcode;

import java.util.HashMap;

public class XOfAKindOfInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {
        /*
            Time Complexity - O(n*log^2(n)) where n is the length of deck
            Space Complexity - O(n)
         */
        if (deck.length <= 1) return false;

        // key is the number and value is the count
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        int gcd = -1;

        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count < 2) return false;
            if (gcd < 0) {
                gcd = count;
            } else {
                gcd = gcd(gcd, count);
                if (gcd < 2) return false;
            }
        }

        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count % gcd != 0) return false;
        }
        return true;
    }

    int gcd(int a, int b) {
        /*
            Time Complexity - O(log^2(n))
         */
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
