package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class RecentCounter {

    List<Integer> pings;

    public RecentCounter() {
        pings = new LinkedList<>();
    }

    public int ping(int t) {
        pings.add(t);

        // remove everything that is not within 3000 milliseconds of the most current ping
        while (!pings.isEmpty() && pings.get(0) < t - 3000) {
            pings.remove(0);
        }

        return pings.size();
    }

//    public int ping(int t) {
//        pings.add(t);
//
//        int count = 0;
//        for (int i = pings.size() - 1; i >= 0; i--) {
//            int ping = pings.get(i);
//            if (t - ping <= 3000) {
//                count++;
//            } else {
//                pings.remove(i);
//            }
//        }
//
//        return count;
//    }
}
