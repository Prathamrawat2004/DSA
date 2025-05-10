package Strings;

import java.math.BigInteger;

public class VersionNumbers {
    public int compareVersion(String A, String B) {
        // removing the leading and trailing spaces
        A = A.trim();
        B = B.trim();

        // splitting on the basis of "."
        String[] A1 = A.split("\\.");
        String[] B1 = B.split("\\.");

        int maxLength = Math.max(A1.length, B1.length);

        for (int i = 0; i < maxLength; i++) {
            BigInteger valA = (i < A1.length && !A1[i].isEmpty()) ? new BigInteger(A1[i]) : BigInteger.ZERO;
            BigInteger valB = (i < B1.length && !B1[i].isEmpty()) ? new BigInteger(B1[i]) : BigInteger.ZERO;

            // comparing values
            if (valA.compareTo(valB) < 0)
                return -1;
            if (valA.compareTo(valB) > 0)
                return 1;

        }

        // version numbers are equal
        return 0;
    }
}
