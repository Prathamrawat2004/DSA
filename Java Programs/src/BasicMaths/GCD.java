package BasicMaths;

public class GCD {
    // brute force
    public int GCD(int n1, int n2) {
        // base conditions
        if (n1 == 0)
            return n2;
        if (n2 == 0)
            return n1;

        int limit = Math.min(n1, n2);
        int gcd = 1; // min gcd = 1

        for (int i = 1; i <= limit; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    // optimized approach
    // EUCLEADEAN ALGORITHM
    // GCD of two numbers does NOT change if you REPLACE the number with the
    // REMAINDER.
    public int GCD2(int n1, int n2) {
        // base conditions
        if (n1 == 0)
            return n2;
        if (n2 == 0)
            return n1;

        while (n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }

        return n1;
    }
}
