package leetcode;

/**
 * https://leetcode.com/problems/nim-game/
 */
public class NimGame {

    /**
     * The solution takes the input determines whether it is divisible by 4.
     * If it is divisible by 4, we cannot win. This can be understood by looking at just the game with 1 to 4 stones.
     * If there are 1 to 3 stones, you win by taking that many stones. If there are 4 stones, you will lose since no matter how many stones you take, the next player will take the remaining number of stones.
     * Now, if we look at any number of stones between 5 and 7, the player on move will simply have to take a number of stones that will make the remaining number of stones 4 in order to win.
     * However, the same losing scenario happens when there are 8 stones - no matter how many stones the player takes, the next player can make it so there are 4 stones remaining.
     * This pattern repeats infinitely, so any number divisible by 4 cannot be won by the player going first.
     * @param n
     * @return
     */
    private boolean canWin(int n) {
        return n > 0 && n % 4 != 0;
    }

    public static void main(String[] args) {
        NimGame n = new NimGame();
        System.out.println(n.canWin(2));
        System.out.println(n.canWin(8));
    }
}
