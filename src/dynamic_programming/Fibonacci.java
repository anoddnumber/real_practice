package dynamic_programming;

/*
    1, 1, 2, 3, 5, 8, 13, 21, 34
 */
public class Fibonacci {

    int[] mem = new int[10000];

    // Using memoization
    int fib(int n) {
        if (n <= 1) {
            return 1;
        }

        if (mem[n] != 0) {
            System.out.println("returning cached value for value n=" + n);
            return mem[n];
        }

        mem[n] = fib(n - 1) + fib(n - 2);
        return mem[n];
    }

    int[] mem2 = new int[10000];

    int fib2(int n) {
        mem2[0] = 1;
        mem2[1] = 1;

        for (int i = 2; i <= n; i++) {
            mem2[i] = mem2[i-1] + mem2[i-2];
        }
        return mem2[n];
    }

    int fib3(int n) {
        if (n == 0 || n == 1) return 1;

        int a = 1;
        int b = 1;
        int c = 2;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int i = 42;
        System.out.println(f.fib(i));
        System.out.println(f.fib2(i));
        System.out.println(f.fib3(i));
    }
}
