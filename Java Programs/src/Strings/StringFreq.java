package Strings;
// revisions = 1
import java.util.HashMap;
import java.util.HashSet;

public class StringFreq {
    public String solve(String A) {
        // removing the leading and trailing spaces
        A = A.trim();

        // creating a hashmap to store characters along with their frequencies
        HashMap<Character, Integer> freqMap = new HashMap();

        // traversing the given string
        for (char ch : A.toCharArray()) {
            // put either adds a new value or updates the current value
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // resultant string
        StringBuilder result = new StringBuilder();

        // creating a hashset as it stores the elements for only once
        HashSet<Character> set = new HashSet<>();
        for (char ch : A.toCharArray()) {
            if (!set.contains(ch)) {
                result.append(ch).append(freqMap.get(ch));
                set.add(ch); // add the current character
            }

        }

        return result.toString();
    }

}
