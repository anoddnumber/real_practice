package leetcode;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        /*
            Time Complexity - O(n * m) where n is the number of words and m is the average number of characters to check
            Space Complexity - O(p) where p is the size of the alphabet used
         */
        if (words.length <= 1) return true;
        Map<Character, Integer> map = getOrderMap(order);
        for (int i = 1; i < words.length; i++) {
            if (! isGreater(words[i - 1], words[i], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean isGreater(String w1, String w2, Map<Character, Integer> map) {
        int len = Math.min(w1.length(), w2.length());
        for (int i = 0; i < len; i++) {
            if (map.get(w1.charAt(i)) < map.get(w2.charAt(i))) {
                return true;
            } else if (map.get(w1.charAt(i)) > map.get(w2.charAt(i))) {
                return false;
            }
        }
        return w1.length() < w2.length();
    }

    private Map<Character, Integer> getOrderMap(String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            Character c = order.charAt(i);
            map.put(c, i);
        }
        return map;
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary v = new VerifyingAnAlienDictionary();
        System.out.println(v.isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")); // true
        System.out.println(v.isAlienSorted(new String[] {"hello","leetcode"}, "worldabcefghijkmnpqstuvxyz")); // false
        System.out.println(v.isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz")); // false
    }
}
