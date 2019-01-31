package leetcode;

/**
 * https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        /*
            Uses a Stringbuilder for better time complexity

            Time Complexity - O(n) where n is the number of characters in the string
            Space Complexity - O(n)
         */
        if (S.length() <= 0) return null;
        StringBuilder b = new StringBuilder(S);
        int firstLetterIndex = 0; //index of the first letter of a word
        int numWord = 1;

        while (true) {
            if (firstLetterIndex >= b.length()) {
                break;
            }

            if (b.charAt(firstLetterIndex) == ' ') {
                firstLetterIndex++;
                continue;
            }

            int spaceIndex = b.indexOf(" ", firstLetterIndex);

            if (spaceIndex < 0) {
                spaceIndex = b.length();
            }

            char c = b.charAt(firstLetterIndex);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
            ) {
                b.insert(spaceIndex, "ma");
                spaceIndex += "ma".length();
            } else {
                b.deleteCharAt(firstLetterIndex);
                spaceIndex--;

                // move the first character to the end of the word
                b.insert(spaceIndex, c);
                spaceIndex++;

                b.insert(spaceIndex, "ma");
                spaceIndex += "ma".length();
            }

            for (int i = 0; i < numWord; i++) {
                b.insert(spaceIndex, "a");
                spaceIndex++;
            }

            if (spaceIndex >= b.length()) {
                break;
            }
            firstLetterIndex = spaceIndex + 1;
            numWord++;
        }
        return b.toString();
    }

    public static void main(String[] args) {
//        StringBuilder b = new StringBuilder("");
//        b.insert(0, "ddd");
//
//        System.out.println("b: " + b);

        GoatLatin g = new GoatLatin();
        System.out.println(g.toGoatLatin("I speak Goat Latin"));
        System.out.println(g.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
