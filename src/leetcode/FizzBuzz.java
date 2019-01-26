package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        /*
            Time Complexity - O(n) where n is the number given
            Space Complexity - O(n)
         */
        List<String> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0;
            boolean mod5 = i % 5 == 0;
            if (mod3 && mod5) {
                l.add("FizzBuzz");
            } else if (mod3) {
                l.add("Fizz");
            } else if (mod5) {
                l.add("Buzz");
            } else {
                l.add(new Integer(i).toString());
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FizzBuzz f = new FizzBuzz();
        System.out.println(f.fizzBuzz(15));
    }
}
