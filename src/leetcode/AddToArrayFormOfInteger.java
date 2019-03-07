package leetcode;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {
        /*
            Time Complexity - O(n + m) where n is the length of A and m is the number of digits in K
            Space Compelxity - O(Max(n,m))
         */
        List<Integer> list = new LinkedList<>();

        int index = A.length - 1;
        int carry = 0;

        while (K > 0 || index >= 0) {
            int digit = K % 10;
            int sum = digit + carry;

            if (index >= 0) {
                sum += A[index];
            }

            carry = sum >= 10 ? 1 : 0;
            list.add(0, sum % 10);

            K = K / 10;
            if (index >= 0) {
                index--;
            }
        }
        if (carry == 1) {
            list.add(0, 1);
        }
        return list;
    }

}
