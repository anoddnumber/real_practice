package leetcode;

//import java.util.stream.IntStream;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        /*
            Time Complexity - O(n) where n is the length of nums
            Space Complexity - O(1)
         */
        int num = nums.length;
        for (int i = 0; i < nums.length; i++) {
            num ^= i ^ nums[i];
        }
        return num;
    }

//    public int missingNumber(int[] nums) {
//        /*
//            First attempt
//            Time Complexity - O(n) where n is the length of nums
//            Space Complexity - O(1)
//         */
//        int expectedSum = nums.length * (nums.length + 1) / 2;
//        int sum = IntStream.of(nums).sum();
//        return expectedSum - sum;
//    }
}
