package Arrays;

import java.math.BigInteger;

// constraint 1 <= A <= 100
public class Factorial {
    public String solve(int A) {

        // using biginteger class because the value of A <= 100 which out passes the int
        // & long range
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= A; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial.toString();

    }
}
