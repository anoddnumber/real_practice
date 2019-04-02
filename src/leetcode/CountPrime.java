package leetcode;

public class CountPrime {

    boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public int countPrimes(int n) {
        /*
            Time Complexity - O(n^2)
            Space Complexity - O(n)
         */
        int count = 0;
        boolean[] notPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
               count++;
               for (int j = 2; i * j < n; j++) {
                   notPrime[i * j] = true;
               }
            }
        }
        return count;
    }
}
