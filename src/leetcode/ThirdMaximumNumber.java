package leetcode;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        /*
            Not the cleanest solution...
            Time Complexity - O(n)
            Space Complexity - O(1)
         */
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        boolean hasMax = false;
        boolean hasSecondMax = false;
        boolean hasThirdMax = false;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max || num == Integer.MIN_VALUE && !hasMax) {
                if (!hasMax) {
                    hasMax = true;
                } else if (!hasSecondMax) {
                    hasSecondMax = true;
                } else if (!hasThirdMax) {
                    hasThirdMax = true;
                }

                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num != max && (num > secondMax || num == Integer.MIN_VALUE  && !hasSecondMax)) {
                if (!hasSecondMax) {
                    hasSecondMax = true;
                } else if (!hasThirdMax) {
                    hasThirdMax = true;
                }
                thirdMax = secondMax;
                secondMax = num;
            } else if (num != max && num != secondMax && (num > thirdMax || num == Integer.MIN_VALUE && !hasThirdMax)) {
                hasThirdMax = true;
                thirdMax = num;
            }
        }

        return hasThirdMax ? thirdMax : max;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber t = new ThirdMaximumNumber();
        System.out.println(t.thirdMax(new int[]{2,2,3,1}));
    }
}
