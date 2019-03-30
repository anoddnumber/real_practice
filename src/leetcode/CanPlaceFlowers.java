package leetcode;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
            Time Complexity - O(n)
            Space Complexity - O(1)
         */
        int numSpotsAvailable = 0;
        int i = 0;
        while (i < flowerbed.length) {
            int pot = flowerbed[i];
            if (pot == 0 && (i - 1 < 0 || flowerbed[i-1] == 0) && (i + 1 >= flowerbed.length || flowerbed[i+1] == 0)) {
                numSpotsAvailable++;
                i += 2;
            } else {
                i++;
            }
        }
        return numSpotsAvailable >= n;
    }
}
