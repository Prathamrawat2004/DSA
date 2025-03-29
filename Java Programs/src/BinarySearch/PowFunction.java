package BinarySearch;

public class PowFunction {
    public int pow(int x, int n, int d) {
        // base condition
        if (d == 1)
            return 0; // anything modulo 1 equals 0

        // as result might overflow int range
        long base = (long) x;
        long result = 1;
        long pow = (long) n;

        // converting negative base to positive
        if (base < 0) {
            base = ((base % d) + d) % d;
        }

        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * base) % d;
            }
            base = (base * base) % d;
            power /= 2;
        }

        return (int) (result + d) % d; // ensuring non-negative result
    }
}
