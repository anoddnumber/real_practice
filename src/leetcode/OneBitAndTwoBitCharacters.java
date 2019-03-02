package leetcode;

// https://leetcode.com/problems/1-bit-and-2-bit-characters/
public class OneBitAndTwoBitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        /*
            Time Complexity - O(n)
            Space Complexity - O(1)
         */
        // whenever we see a 0, increment by 1
        // whenever we see a 1, increment by 2
        // if the ending value is equal to length - 1, it means that [0, length - 1] is a valid array.

        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

//    public boolean isOneBitCharacter(int[] bits) {
//        /*
//            Attempt 1
//            Time Complexity - O(n) where n is the number of bits
//            Space Complexity - O(n) due to using recursion
//         */
//        return bits[bits.length - 1] == 0 && isValidArray(bits, 0, bits.length - 2);
//    }
//
//    boolean isValidArray(int[] bits, int start, int end) {
//        if (start > end) return true;
//
//        boolean isValid = true;
//        if (bits[start] == 0) {
//            isValid &= isValidArray(bits, start + 1, end);
//        } else {
//            // this is the last bit
//            if (start == end) return false;
//            isValid &= isValidArray(bits, start + 2, end);
//        }
//        return isValid;
//    }
}
