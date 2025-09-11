package InfosysExtraProblems;

import java.util.*;
// For any divisor d of n:
// d ≤ √n has a paired divisor n / d ≥ √n.
// So some divisors are below or equal to √n, and their pair is above or equal to √n.

public class SumOfPrimes {
    // brute force approach
    public int primeSum(int n) {
        int sum = 0; // calculating the sum

        for (int i = 2; i <= n; i++) {

            boolean flag = true; // to check if prime or not

            for (int j = 2; j <= i / 2; j++) {
                // or j <= Math.sqrt(i)
                // if divisible, hence not prime
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                // it's a prime number
                sum += i;
            }

        }

        return sum;
    }

    // optimized approach (Sieve of Eratosthemes)
    // O(nloglogn)
    public int primeSum2(int n) {
        // creating an array
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        // base condition
        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {

            // if the current number is prime
            if (prime[i]) {
                // setting the multiples of current number as non-prime
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // adding the prime numbers
        int Sum = 0;

        for (int k = 2; k <= n; k++) {
            if (prime[k]) {
                Sum += k;
            }
        }

        return Sum;

    }
}
