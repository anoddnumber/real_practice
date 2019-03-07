package leetcode;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /*
            Time Complexity - O(1)
            Space Complexity - O(1)
         */
        return hasIntersection(rec1[0], rec1[2], rec2[0], rec2[2]) &&
                hasIntersection(rec1[1], rec1[3], rec2[1], rec2[3]);
    }

    // returns true if the range from x1 to x2 has some intersection with the range from x3 to x4
    // intersections are exclusive at the edges (if x2 == x3, it does not count)
    // x1 < x2 and x3 < x4
    private boolean hasIntersection(int x1, int x2, int x3, int x4) {
        if (x1 > x3 && x1 < x4 || x3 > x1 && x3 < x2) {
            return true;
        }

        if (x2 > x3 && x2 < x4 || x4 > x1 && x4 < x2) {
            return true;
        }

        if (x1 == x3 && x2 > x1 && x4 > x3 || x2 == x4 && x1 < x2 && x3 < x4) {
            return true;
        }

        return false;
    }
}
