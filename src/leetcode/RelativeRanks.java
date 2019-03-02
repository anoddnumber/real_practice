package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        /*
            Time Complexity - O(n * log(n)) where n is the length of nums
            Space Complexity - O(n)
         */
        int[] numsTmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsTmp);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < numsTmp.length; i++) {
            int position = nums.length - i;
            switch(position) {
                case 1:
                    map.put(numsTmp[i], "Gold Medal");
                    break;
                case 2:
                    map.put(numsTmp[i], "Silver Medal");
                    break;
                case 3:
                    map.put(numsTmp[i], "Bronze Medal");
                    break;
                default:
                    map.put(numsTmp[i], String.valueOf(position));
            }
        }

        String[] ret = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            ret[i] = map.get(num);
        }
        return ret;
    }
}
