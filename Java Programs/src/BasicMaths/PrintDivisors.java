package BasicMaths;

import java.util.ArrayList;

public class PrintDivisors {
    // brute force
    public ArrayList<Integer> divisors(int n) {
        // resultant list
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(n);
        }

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                // divisor found
                result.add(i);
            }
        }

        return result;
    }

    // optimized
    public ArrayList<Integer> divisors2(int n) {
        // resultant list
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(n);
        }

        int sqroot = (int) Math.sqrt(n);
        for (int i = 1; i <= sqroot; i++) {
            if (n % i == 0) {
                result.add(i);
                if (n / i != i) {
                    result.add(n / i);
                }
            }
        }

        return result;

    }
}
