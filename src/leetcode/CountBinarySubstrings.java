package leetcode;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        /*
            Time Complexity - O(n) where n is the number of characters in s
            Space Complexity - O(1)
         */
        if (s == null || s.length() == 0) return 0;

        int numBinarySubstrings = 0;
        int prevChar = s.charAt(0);
        int prevCount = -1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prevChar) {
                count++;
            } else {
                if (prevCount > 0) {
                    numBinarySubstrings += Math.min(prevCount, count);
                }
                prevCount = count;
                count = 1;
                prevChar = c;
            }
        }
        if (prevCount > 0) {
            numBinarySubstrings += Math.min(prevCount, count);
        }
        return numBinarySubstrings;
    }

//    public int countBinarySubstrings(String s) {
//        int numBinarySubstrings = 0;
//        List<Integer> counts = constructCounts(s);
//        for (int i = 1; i < counts.size(); i++) {
//            int prevCount = counts.get(i-1);
//            int count = counts.get(i);
//            numBinarySubstrings += Math.min(prevCount, count);
//        }
//        return numBinarySubstrings;
//    }
//
//    List<Integer> constructCounts(String s) {
//        int count = 0;
//        Character prev = null;
//        List<Integer> counts = new ArrayList<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (prev == null || prev.charValue() == c) {
//                count++;
//            } else {
//                counts.add(count);
//                count = 1;
//            }
//            prev = c;
//        }
//        counts.add(count);
//        return counts;
//    }

    public static void main(String[] args) {
        CountBinarySubstrings c = new CountBinarySubstrings();
        System.out.println(c.countBinarySubstrings("0")); // 0
        System.out.println(c.countBinarySubstrings("00110011")); // 6
        System.out.println(c.countBinarySubstrings("000110011")); // 6
        System.out.println(c.countBinarySubstrings("10101")); // 4
    }
}
