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

        while (pow > 0) {
            if (pow % 2 == 1) {
                pow = (result * base) % d;
            }
            base = (base * base) % d;
            pow /= 2;
        }

        return (int) (result + d) % d; // ensuring non-negative result
    }

    // method O(N)
    // public static int power(int x, int y) {
    // if (y == 0)
    // return 1;
    // if (y % 2 == 0)
    // return power(x, y / 2) * power(x, y / 2);
    // return x * power(x, y / 2) * power(x, y / 2);
    // }

    // method 3 O(logn)
    // int fastPower(int x, int y) {
    //     if (y == 0)
    //         return 1;
    //     int half = fastPower(x, y / 2);

    //     if (y % 2 == 0)
    //         return half * half;
    //     else
    //         return x * half * half;
    // }

}
