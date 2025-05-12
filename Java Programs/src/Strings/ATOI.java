package Strings;

public class ATOI {
    public int String(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // getting the sign of number
        int i = 0;
        int sign = 1;
        if (A.charAt(i) == '-') {
            sign = -1;
            i++; // moving to next integer
        } else {
            sign = 1;
            i++; // moving to next integer
        }

        int result = 0; // final converted string to integer
        while (i < A.length() && Character.isDigit(A.charAt(i))) {
            int digit = A.charAt(i) - '0';

            // in case of overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // adding it to result
            result = result * 10 + digit;
        }

        return result;
    }
}
