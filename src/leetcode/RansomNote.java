package leetcode;

import java.util.HashMap;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        /*
            Time Complexity - O(m + n) where m and n are the number of characters in the ransomNote and magazine
            Space Complexity - O(n)
         */
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            int count = map.containsKey(c) ? map.get(c) + 1 : 1;
            map.put(c, count);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            int count = map.containsKey(c) ? map.get(c) - 1 : -1;
            if (count == -1) return false;
            map.put(c, count);
        }
        return true;
    }
}
