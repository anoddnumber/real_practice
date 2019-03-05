package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        /*
            Time Complexity - O(n + m) where n is the length of list1 and m is the length of list2
            Space Complexity - O(n)
         */
        List<String> restaurants = new LinkedList<>();
        int indexSum = Integer.MAX_VALUE;

        // key is the restaurant name
        // value is the index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            String restaurant = list1[i];
            map.put(restaurant, i);
        }

        for (int i = 0; i < list2.length; i++) {
            String restaurant = list2[i];
            if (map.containsKey(restaurant)) {
                int sum = map.get(restaurant) + i;
                if (indexSum > sum) {
                    indexSum = sum;
                    restaurants = new LinkedList<>();
                    restaurants.add(restaurant);
                } else if (indexSum == sum) {
                    restaurants.add(restaurant);
                }
            }
        }

        return restaurants.toArray(new String[0]);
    }

}
