package leetcode;

import java.util.*;

public class KeyboardRow {

    Character[] topRow = {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'
    };

    Character[] middleRow = {
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'
    };

    Character[] bottomRow = {
            'z', 'x', 'c', 'v', 'b', 'n', 'm'
    };

    final Set<Character> topRowSet = new HashSet<>(Arrays.asList(topRow));
    final Set<Character> middleRowSet = new HashSet<>(Arrays.asList(middleRow));
    final Set<Character> bottomRowSet = new HashSet<>(Arrays.asList(bottomRow));

    public String[] findWords(String[] words) {
        /*
            Time complexity - O(n) where n is total number of characters in all the words
            Space complexity - O(1) - we have 3 character arrays that store 26 characters and 3 sets that store 26 characters
         */
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (containsAllIn1Row(word)) {
                ret.add(word);
            }
        }

        return ret.toArray(new String[0]);
    }

    private boolean containsAllIn1Row(String word) {
        if (word.length() <= 0) {
            return true;
        }

        Set<Character> row;
        Character firstChar = Character.toLowerCase(word.charAt(0));

        // determine which set to use
        if (topRowSet.contains(firstChar)) {
            row = topRowSet;
        } else if (middleRowSet.contains(firstChar)) {
            row = middleRowSet;
        } else {
            row = bottomRowSet;
        }

        for (Character c : word.toCharArray()) {
            c = Character.toLowerCase(c);
            if (! row.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KeyboardRow k = new KeyboardRow();

        String[] a = {
                "Hello", "Alaska", "Dad", "Peace"
        };
        System.out.println(Arrays.toString(k.findWords(a)));
    }
}
