package BasicMaths;

public class ArmstrongNumber {
    // brute force
    public boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;

        int length = String.valueOf(n).length(); // 153 -> "153"-> length = 3
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, length);
            n = n / 10;
        }

        return sum == original;
    }

    // optimized
    // removing the overhead of conversion to string which takes O(N)
    // not using Math.pow() 
    public boolean isArmstrong2(int n) {
        int original = n;
        int temp = n;
        int digits = 0;
        int sum = 0;

        // calculating the number of digits
        while (temp > 0) {
            digits++;
            temp = temp / 10;
        }

        // calculating the sum
        temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            int pow = 1;

            for (int i = 0; i < digits; i++) {
                pow = pow * digit;
            }

            sum += pow;
            temp = temp / 10;
        }

        return sum == original;
    }
}
