package leetcode;

/*
    https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        /*
            Time Complexity - O( (R - L) * R )
            Space Complexity - O(1)
         */
        int count = 0;
        for (int i = L; i <= R; i++) {
            count = isPrime(countSetBits(i)) ? count + 1 : count;
        }
        return count;
    }

    private int countSetBits(int num) {
        // Brian Kernighan’s Algorithm
        int count = 0;
        while (num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }

    //https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/
    private boolean isPrime(int n)
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

    public static void main(String[] args) {
        PrimeNumberOfSetBitsInBinaryRepresentation p = new PrimeNumberOfSetBitsInBinaryRepresentation();
        System.out.println(p.countPrimeSetBits(6, 10)); // 4
        System.out.println(p.countPrimeSetBits(10, 15)); // 5
    }
}
