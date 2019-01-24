package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/
 */
public class GroupsOfSpecialEquivalentStrings {

    public int numSpecialEquivGroups(String[] A) {
        /*
            Time Complexity - O(n) where n is the number of strings in the input
            Space Complexity - O(n)
         */
        Set<String> set = new HashSet();
        for (String s : A) {
            int[] odd = new int[26];
            int[] even = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i % 2 == 0) {
                    even[c - 'a']++;
                } else {
                    odd[c - 'a']++;
                }
            }

            String key = Arrays.toString(odd) + Arrays.toString(even);
            set.add(key);
        }
        return set.size();
    }

    public static void main(String[] args) {
        GroupsOfSpecialEquivalentStrings g = new GroupsOfSpecialEquivalentStrings();

        // 3
        System.out.println(g.numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
    }
}
