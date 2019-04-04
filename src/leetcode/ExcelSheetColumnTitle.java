package leetcode;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        /*
            Time Complexity - O(m) where m is the number of digits in n
            Space Complexity - O(m)
         */
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        System.out.println(e.convertToTitle(53));
    }

}
