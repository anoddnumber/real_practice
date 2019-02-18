package leetcode;

import java.util.HashMap;

public class FindTheDifference {

    // attempt 1
//    public char findTheDifference(String s, String t) {
        /*
            Time Complexity - O(n) where n is the number of characters in s
            Space Complexity - O(n)
         */
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            Integer count = map.get(c);
//            if (count == null) {
//                map.put(c, 1);
//            } else {
//                map.put(c, count + 1);
//            }
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            char c = t.charAt(i);
//            Integer count = map.get(c);
//            if (count == null) {
//                return c;
//            }
//            count--;
//            if (count == 0) {
//                map.remove(c);
//            } else {
//                map.put(c, count);
//            }
//        }
//        // will never reach this
//        return 'a';
//    }

    public char findTheDifference(String s, String t) {
        /*
            Time Complexity - O(n) where n is the number of characters in s
            Space Complexity - O(1)
         */
        char c = 0;
        for (int i = 0; i < t.length(); i++) {
            c += t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            c -= s.charAt(i);
        }
        return c;
    }
}
