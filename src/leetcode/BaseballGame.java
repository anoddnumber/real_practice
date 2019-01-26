package leetcode;

import java.util.Stack;

public class BaseballGame {

    Stack<Integer> validPoints = new Stack<>();

    public int calPoints(String[] ops) {
        /*
            Time Complexity - O(n) where n is the size of the string
            Space Complexity - O(n)
         */
        for (String s : ops) {
            handleString(s);
        }
        int sum = 0;
        while (!validPoints.isEmpty()) {
            sum += validPoints.pop();
        }
        return sum;
    }

    void handleString(String s) {
        if (s.equals("+")) {
            handlePlus();
        } else if (s.equals("D")) {
            handleD();
        } else if (s.equals("C")) {
            handleC();
        } else {
            handleNumber(s);
        }
    }

    void handlePlus() {
        if (!validPoints.isEmpty()) {
            int one = validPoints.pop();
            int sum = one;
            if (!validPoints.isEmpty()) {
                sum += validPoints.peek();
            }
            validPoints.push(one);
            validPoints.push(sum);
        } else {
            validPoints.push(0);
        }
    }

    void handleD() {
        if (validPoints.isEmpty()) {
            validPoints.push(0);
        } else {
            validPoints.push(2 * validPoints.peek());
        }
    }

    void handleC() {
        if (!validPoints.isEmpty()) {
            validPoints.pop();
        }
    }

    void handleNumber(String s) {
        validPoints.push(Integer.parseInt(s));
    }

    public static void main(String[] args) {
        BaseballGame b = new BaseballGame();
        String[] s = {"5","2","C","D","+"};
        System.out.println(b.calPoints(s)); // 30

        String[] s2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(b.calPoints(s2)); // 27
    }
}
