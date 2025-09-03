package RECURSION.Backtracking;

public class Fibonacci {
    // Recursive method to get nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // base case: fib(0)=0, fib(1)=1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive case
    }
}
