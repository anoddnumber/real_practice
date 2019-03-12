package leetcode;

public class Base7 {

    public String convertToBase7(int num) {
        /*
            Time Complexity - O(log7(n)) where n = num
            Space Complexity - O(log7(n)) number of characters
         */
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append("-");
            num *= -1;
        }

        int highestPower = (int) (Math.log(num) / Math.log(7));
        while (highestPower >= 0) {
            int divisor = (int) Math.pow(7, highestPower);
            int digit = num / divisor;
            sb.append(digit);
            num = num - divisor * digit;
            highestPower--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(13));
        System.out.println(new Base7().convertToBase7(14));
    }

}
