package Strings;

public class ZigZag {
    public String convert(String A, int B) {
        // removing the leading and trailing spaces
        A = A.trim();

        // base case
        if (B == 1 || A.length() <= B) {
            return A;
        }

        StringBuilder[] rows = new StringBuilder[B];

        // adding each string row
        for (int i = 0; i < B; i++) {
            // assigning stringbuilders which were initially null
            rows[i] = new StringBuilder();
        }

        int step = 1; // for upward and downward movement
        int index = 0;

        // adding character one by one to each row
        for (char c : A.toCharArray()) {
            rows[index].append(c);

            if (index == 0) {
                // move downward
                step = 1;
            } else if (index == B - 1) {
                // move upward
                step = -1;
            }

            index += step;

        }

        // combining all the rows
        StringBuilder combined = new StringBuilder();
        for (StringBuilder row : rows) {
            combined.append(row);

        }

        return combined.toString();

    }
}
