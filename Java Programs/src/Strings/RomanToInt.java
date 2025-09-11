package Strings;
// revisions = 1
import java.util.HashMap;

public class RomanToInt {
    public int romanToInt(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // storing the common roman values
        HashMap<String, Integer> romanMap = new HashMap<>();

        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);

        int i = 0;
        int num = 0; // for storing the number
        int n = A.length();

        while (i < n) {
            if (i + 1 < n && romanMap.containsKey(A.substring(i, i + 2))) {
                num += romanMap.get(A.substring(i, i + 2));

                // moving i to two places
                i += 2;

            } else {
                
                // adding the current ith value
                num += romanMap.get(A.substring(i, i + 1));

                // moving i to 1 places
                i += 1;
            }

        }

        return num;
    }
}
