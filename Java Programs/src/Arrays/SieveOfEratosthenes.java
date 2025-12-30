package Arrays;
// to print all the prime numbers from 0 -> N

import java.util.*;

public class SieveOfEratosthenes {
    public static void sieve(int n) {
        // base condition
        if (n == 0 || n == 1) {
            System.out.println("Neither Prime Nor Composite!");
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // processing each integer till 'n' & marking the multiples of each as 0
        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // printing the prime numbers
        for (int k = 2; k <= n; k++) {
            if (isPrime[k]) {
                System.out.println(k + " ");
            }
        }
    }
}
