package leetcode;

public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        /*
            Time Complexity - O(n ^ 1/2) where n is the area given
            Space Complexity - O(1)
         */
        int num = (int) Math.sqrt(area);
        while (area % num != 0) {
            num--;
        }
        return new int[] {area / num, num};
    }

}
