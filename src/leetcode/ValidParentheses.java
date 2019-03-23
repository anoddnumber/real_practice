package leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.HashMap;

public class ValidParentheses {

    public boolean isValid(String s) {
        /*
            Time Complexity - O(n) where n is the length of s
            Space Complexity - O(n)
         */
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> m = new HashMap<>();
        m.put(')', '(');
        m.put('}', '{');
        m.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c =='[') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;

                char popped = stack.pop();
                if (!m.containsKey(c) || m.get(c) != popped) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
