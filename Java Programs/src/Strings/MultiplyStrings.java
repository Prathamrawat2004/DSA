package Strings;

public class MultiplyStrings {
    public String multiply(String A, String B) {
        // removing the leading and trailing spaces
        A = A.trim();
        B = B.trim();

        // resultant array
        int[] product = new int[A.length() + B.length()];

        // multiplying every digit of A with every digit of B
        for (int i = A.length() - 1; i >= 0; i--) {
            for (int j = B.length() - 1; j >= 0; j--) {
                int mul = (A.charAt(i) - '0') * (B.charAt(j) - '0');

                int sum = mul + product[i + j + 1];

                // setting the current value
                product[i + j + 1] = sum % 10;

                // setting the carry value
                product[i + j] = sum / 10;
            }
        }

        // converting to string
        StringBuilder sb = new StringBuilder();
        for (int num : product) {
            // skipping the leading zeros
            while (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
