package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        /*
            Time Complexity - O(n ^ 2)
            Space Complexity - O(n ^ 2)
         */
        if (numRows <= 0) return new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);
        if (numRows == 1) {
            return ret;
        }

        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        ret.add(list);
        List<Integer> prev = list;

        for (int i = 2; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(prev.get(j - 1) + prev.get(j));
            }
            list.add(1);
            ret.add(list);
            prev = list;
        }

        return ret;
    }
}
