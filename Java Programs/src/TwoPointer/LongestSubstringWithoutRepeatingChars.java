package TwoPointer;
// revision = 1
import java.util.*;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {

        // using the sliding window approach
        int left = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // incrementing the left value
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }
}