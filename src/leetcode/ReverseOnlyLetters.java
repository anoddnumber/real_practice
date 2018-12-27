package leetcode;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {

    /**
     * The idea is to use 2 pointers, 1 at the front of the string and 1 at the end of the string
     * As long as neither of the pointers are pointing to letters, increment/decrement them respectively.
     * If the first pointer is past the second pointer, stop.
     * Swap the characters at the pointers.
     * Repeat.
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int f = 0; //front pointer
        int b = chars.length - 1; //back pointer

        while (f < b) {
            char c1 = chars[f];
            if (!Character.isLetter(c1)) {
                f++;
                continue;
            }

            char c2 = chars[b];
            if (!Character.isLetter(c2)) {
                b--;
                continue;
            }

            swap(f, b, chars);
            f++;
            b--;
        }

        return new String(chars);
    }

    private void swap(int i, int j, char[] c) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) {
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        System.out.println(r.reverseOnlyLetters(""));
        System.out.println(r.reverseOnlyLetters("ab-cd"));
        System.out.println(r.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(r.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
