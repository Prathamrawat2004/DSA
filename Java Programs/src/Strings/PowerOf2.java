package Strings;

import java.math.BigInteger;

public class PowerOf2 {
    public int power(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // as the number can be more than 64 digits long, i.e (> long datatype)
        // converting the number to biginteger object
        BigInteger num = new BigInteger(A);

        // if the number is already 1 (or less than 1)
        if (num.compareTo(BigInteger.ONE) <= 0) {
            return 0;
        }

        // dividing till the number becomes equal to 1
        while (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            num = num.divide(BigInteger.valueOf(2));
        }

        return (num.equals(BigInteger.ONE)) ? 1 : 0;

    }
}
