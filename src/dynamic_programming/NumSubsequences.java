package dynamic_programming;

import java.util.HashSet;

public class NumSubsequences {

    static int getNumSubsequencesBruteForce(String s) {
        return getSubsequencesBruteForce(s).size();
    }

    static HashSet<String> getSubsequencesBruteForce(String s) {
        HashSet<String> set = new HashSet<>();
        if (s == "") {
            return set;
        }

        if (s.length() == 1) {
            set.add(s);
            return set;
        }

        HashSet<String> res = getSubsequencesBruteForce(s.substring(0, s.length() - 1));
        for (String str : res) {
            set.add(str + s.charAt(s.length() - 1));
        }
        set.add(s.charAt(s.length() - 1) + "");
        set.addAll(res);
        return set;
    }

    static int getNumSubsequencesMemoization(String s) {
        return getSubsequencesMemoization(s).size();
    }

    static HashSet<String> getSubsequencesMemoization(String s) {
        HashSet<String>[] memo = new HashSet[s.length()];
        return getSubsequencesMemoization(s, memo);
    }

    static HashSet<String> getSubsequencesMemoization(String s, HashSet<String>[] memo) {
        HashSet<String> set = new HashSet<>();
        if (s == "") {
            return set;
        }

        if (s.length() == 1) {
            set.add(s);
            return set;
        }

        if (memo[s.length() - 1] == null) {
            HashSet<String> res = getSubsequencesMemoization(s.substring(0, s.length() - 1));
            for (String str : res) {
                set.add(str + s.charAt(s.length() - 1));
            }
            set.add(s.charAt(s.length() - 1) + "");
            set.addAll(res);
            memo[s.length() - 1] = set;
        }

        return memo[s.length() - 1];
    }

    static int getNumSubsequencesTabulation(String s) {
        return getSubsequencesTabulation(s).size();
    }

    static HashSet<String> getSubsequencesTabulation(String s) {
        HashSet<String>[] memo = new HashSet[s.length()];
        HashSet<String> set = new HashSet<>();
        set.add(s.charAt(0) + "");
        memo[0] = set;

        for (int i = 1; i < s.length(); i++) {
            set = new HashSet<>();
            for (String subseq : memo[i - 1]) {
                set.add(subseq + s.charAt(i));
            }
            set.add(s.charAt(i) + "");
            set.addAll(memo[i - 1]);
            memo[i] = set;
        }
        return memo[s.length() - 1];
    }

    public static void main(String[] args) {
        String str = "ABC";

        System.out.println(getSubsequencesBruteForce(str));
        System.out.println(getNumSubsequencesBruteForce(str));

        System.out.println(getSubsequencesMemoization(str));
        System.out.println(getNumSubsequencesMemoization(str));

        System.out.println(getSubsequencesTabulation(str));
        System.out.println(getNumSubsequencesTabulation(str));
    }
}
