package leetcode;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        /*
            Second attempt, for fun/education.
            Time Complexity - O(n) where n is the length of cost
            Space Complexity - O(n)
         */
        int[] cache = new int[cost.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        return Math.min(minCostClimbingStairs(cost, 0, cache), minCostClimbingStairs(cost, 1, cache));
    }

    public int minCostClimbingStairs(int[] cost, int index, int[] cache) {
        if (index < 0 || index >= cost.length) return 0;
        if (cache[index] >= 0) return cache[index];

        int theCost = cost[index] + Math.min(minCostClimbingStairs(cost, index + 1, cache), minCostClimbingStairs(cost, index + 2, cache));
        cache[index] = theCost;
        return theCost;
    }


//    public int minCostClimbingStairs(int[] cost) {
//        /*
//            First attempt, building the cost from the back to the front
//            Time Complexity - O(n) where n is the length of cost
//            Space Complexity - O(1)
//         */
//        if (cost.length == 1) return cost[0];
//
//        for (int i = cost.length - 3; i >= 0; i--) {
//            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
//        }
//        return Math.min(cost[0], cost[1]);
//    }

}
