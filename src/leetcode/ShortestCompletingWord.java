package leetcode;

import java.util.HashMap;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        /*
            Time Complexity - O(n * m) where n is the number of characters in licensePlate and m is the average word length in words
            Space Complexity - O(p) where p is the longest word in words
         */
        int shortestWordLength = -1;
        String shortestWord = null;

        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            if ((shortestWordLength < 0 || word.length() < shortestWordLength) && containsLetters(licensePlate, word)) {
                shortestWord = word;
                shortestWordLength = word.length();
            }
        }
        return shortestWord;
    }

    private boolean containsLetters(String licensePlate, String word) {
        //returns true if all letters in licensePlate are in word
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (Character.isLetter(c)) {
                Integer val = map.get(c);
                if (val == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, val + 1);
                }
            }
        }

        for (int i = 0; i < licensePlate.length(); i++) {
            char c = Character.toLowerCase(licensePlate.charAt(i));
            if (Character.isLetter(c)) {
                Integer val = map.get(c);
                if (val == null || val <= 0) {
                    return false;
                }
                map.put(c, val - 1);
            }
        }
        return true;
    }
}
