import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Dominion {


    public static void main(String[] args) {
        String[] setsArr = {
                "Base",
                "Intrigue",
                "Hinterlands",
                "Prosperity",
                "Adventures"
        };

        List<String> sets = new LinkedList<>(Arrays.asList(setsArr));
        System.out.println(Arrays.toString(choose(sets, 2)));

        int num = ThreadLocalRandom.current().nextInt(0, 10); // between 1 and 9
//        System.out.println("numCards from expansions: " + num + ", "+ (10 - num));
        System.out.println("numCards from expansions: " +
                Arrays.toString(selectNumbers(10, 2)));
    }

    private static String[] choose(List<String> list, int num) {
        String[] ret = new String[num];
        for (int i = 0; i < num; i++) {
            if (list.isEmpty()) break;

            int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
            ret[i] = list.remove(randomNum);
        }

        return ret;
    }

    /**
     * Given a number total, return an integer array that contains
     random integer values whose sum equals the total.
     * Each value will be less than or equal to total and greater than
     or equal to 0. In other words, each value has a possible value of [0,
     total]
     * This gives a bell curve distribution.
     *
     * total - the sum of the integers returned will equal total
     * numElements - the number of elements in the returned array
     */
    private static int[] selectNumbers(int total, int numElements) {
        int[] ret = new int[numElements];
        for (int i = 0; i < total; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, numElements);
            ret[randomNum]++;
        }
        return ret;
    }
}
