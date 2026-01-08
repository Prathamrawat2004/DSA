package BasicMaths;

public class CheckPrime {
    // brute force
    public boolean isPrime(int n) {
        // base condition
        if (n <= 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        for (int i = 3; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // optimized
    public boolean isPrime2(int n) {
        // base conditions
        if (n <= 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        // if the number is even and greater than 2
        if (n % 2 == 0) {
            return false;
        }

        // checking till root of n & checking only odd numbers
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;

    }
}
