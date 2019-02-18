package leetcode;

public class RotatedDigits {
    public int rotatedDigits(int N) {
        /*
            This is pretty slow but I didn't like this problem so I didn't bother making it faster
            Time Complexity - O(n * N) where n is the average number of digits in each number
            Space Complexity - O(n)
         */
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (isGoodNumber(new Integer(i).toString())) {
                count++;
            }
        }
        return count;
    }

    boolean isGoodNumber(String num) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < num.length(); i++) {
                char c = num.charAt(i);
                sb.append(rotateNumber(c));
            }
            return ! sb.toString().equals(num);
        } catch(Exception e) {
            return false;
        }
    }

    char rotateNumber(char num) throws Exception {
        switch (num) {
            case '0': return '0';
            case '1': return '1';
            case '2': return '5';
            case '5': return '2';
            case '6': return '9';
            case '8': return '8';
            case '9': return '6';
        }
        throw new Exception();
    }

    public static void main(String[] args) {
        RotatedDigits r = new RotatedDigits();
        System.out.println(r.rotatedDigits(10)); // 4
        System.out.println(r.rotatedDigits(857)); // 247
    }
}
