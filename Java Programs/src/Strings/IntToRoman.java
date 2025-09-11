package Strings;
// revisions = 1
public class IntToRoman {
    public String intToRoman(int A) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        // string builder for roman
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (A >= values[i]) {
                A -= values[i];

                // adding to roman
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }
}
