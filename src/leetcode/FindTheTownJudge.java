package leetcode;

import java.util.HashMap;

public class FindTheTownJudge {

    class Person {
        boolean canBeJudge = true;
        int numTrusts = 0;
    }

    public int findJudge(int N, int[][] trust) {
        /*
            Time Complexity - O(m) where m is the length of trust
            Space Complexity - O(m)
         */
        if (trust.length == 0 && N == 1) return 1;
        // key = the label of the person
        HashMap<Integer, Person> map = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            int[] trustPair = trust[i];
            int current = trustPair[0];
            int trustedPerson = trustPair[1];

            Person p = map.containsKey(current) ? map.get(current) : new Person();
            p.canBeJudge = false;
            map.put(current, p);

            p = map.containsKey(trustedPerson) ? map.get(trustedPerson) : new Person();
            p.numTrusts++;

            map.put(trustedPerson, p);
        }

        for (Integer label : map.keySet()) {
            Person p = map.get(label);
            if (p.canBeJudge && p.numTrusts == N - 1) return label;
        }
        return -1;
    }

}
