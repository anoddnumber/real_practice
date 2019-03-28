package leetcode;

import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        /*
            Time Complexity - O(n) where n is the length of pattern
            Space Complexity - O(n)
         */
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();

        String[] words = str.split(" ");

        if (pattern.length() != words.length) return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c) || reverseMap.containsKey(words[i])) {
                if (!words[i].equals(map.get(c)) || reverseMap.get(words[i]) != c) {
                    return false;
                }
            } else {
                map.put(c, words[i]);
                reverseMap.put(words[i], c);
            }
        }
        return true;
    }
}
