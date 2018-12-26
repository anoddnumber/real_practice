package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    /**
     * Keeps track of the mapping from character s to t with a HashMap.
     * Also keeps track of the values in the HashMap with a HashSet to make it fast to look up if a character already maps to a value
     *
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> h = new HashMap();
        Set<Character> mySet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (h.containsKey(sc)) {
                if (h.get(sc) != tc) return false;
            } else {
                if (mySet.contains(tc)) return false;
                h.put(sc, tc);
                mySet.add(tc);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings o = new IsomorphicStrings();
        System.out.println(o.isIsomorphic("egg", "add")); // true
        System.out.println(o.isIsomorphic("foo", "bar")); // false
        System.out.println(o.isIsomorphic("paper", "title")); // true
        System.out.println(o.isIsomorphic("ab", "aa")); // false
        System.out.println(o.isIsomorphic("ab", "ca")); // true
    }
}
