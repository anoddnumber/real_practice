package leetcode;

public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        /*
            Time Complexity - O(log(n))
            Space Complexity - O(1)
         */
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;

        long low = 2;
        long high = num;
        while (low <= high) {
            long pick = (int) ((low + high) / 2);
            long square = pick * pick;
            if (square == (long) num) {
                return true;
            }

            if (square < num) {
                low = pick + 1;
            } else {
                high = pick - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare is = new IsPerfectSquare();
//        for (int i = 0; i < 26; i++) {
//            System.out.println("i: " + i + ", isPerfectSquare: " + is.isPerfectSquare(i));
//        }

        System.out.println(is.isPerfectSquare(2147483647));

    }
}
