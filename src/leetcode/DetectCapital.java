package leetcode;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        /*
            Time Complexity - O(n) where n is the number of characters in the word
            Space Complexity - O(1)
         */
        return isAllCapital(word) || isAllLowercase(word) || isOnlyFirstLetterCapitalized(word);
    }

    private boolean isAllCapital(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (! Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllLowercase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (! Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isOnlyFirstLetterCapitalized(String word) {
        if (word == null || word.length() <= 0 || !Character.isUpperCase(word.charAt(0))) {
            return false;
        }

        for (int i = 1; i < word.length(); i++) {
            if (! Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
