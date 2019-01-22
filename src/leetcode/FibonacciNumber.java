package leetcode;

public class FibonacciNumber {


    public int fib(int N) {
        double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), N);
        double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), N);

        return (int) Math.floor((f1 - f2) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        FibonacciNumber f = new FibonacciNumber();
        System.out.println(f.fib(10));
    }

}
