package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        /*
            Time Complexity - O(n)
            Space Complexity - O(1)
         */
        List<List<Integer>> ret = new ArrayList<>();

        int begIndex = -1;
        int count = 0;
        Character prevChar = null;
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (c.equals(prevChar)) {
                count++;
            } else {
                if (count >= 3) {
                    add(begIndex, i - 1, ret);
                }
                begIndex = i;
                count = 1;
                prevChar = c;
            }
        }

        if (count >= 3) {
            add(begIndex, S.length() - 1, ret);
        }

        return ret;
    }

    void add(int beg, int end, List<List<Integer>> list) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(beg);
        tmp.add(end);
        list.add(tmp);
    }
}
