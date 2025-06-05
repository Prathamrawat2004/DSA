package Strings;

public class AddBinary {
    public String add(String A, String B) {
        // removing the leading and trailing spaces
        A = A.trim();
        B = B.trim();

        // resultant string to return
        StringBuilder resultant = new StringBuilder();

        // initializing pointers
        int i = A.length() - 1, j = B.length() - 1;
        int sum = 0, carry = 0;

        // adding the binary strings
        while (i >= 0 || j >= 0 || carry > 0) {
            sum = carry;

            if (i >= 0) {
                sum += A.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += A.charAt(j) - '0';
                j--;
            }

            resultant.append(sum % 2);

            carry = sum / 2;
        }

        return resultant.reverse().toString();
    }
}
