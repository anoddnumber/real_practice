package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        /*
            Time Complexity - O(n * m) where n is the length of s and m is the length of p
            Space Complexity - O(n)
         */
        List<Integer> ret = new LinkedList<>();
        if (p.length() > s.length()) return ret;

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            Character c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }

        if (pmap.equals(smap)) {
            ret.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            Character prev = s.charAt(i - p.length());
            Character next = s.charAt(i);
            int val = smap.get(prev) - 1;
            if (val == 0) {
                smap.remove(prev);
            } else {
                smap.put(prev, smap.get(prev) - 1);
            }

            smap.put(next, smap.getOrDefault(next, 0) + 1);
            if (smap.equals(pmap)) {
                ret.add(i - p.length() + 1);
            }
        }
        return ret;
    }
}
