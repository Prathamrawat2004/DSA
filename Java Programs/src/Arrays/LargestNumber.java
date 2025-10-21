package Arrays;
// revisions = 1
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        // converting to string list
        ArrayList<String> strNum = new ArrayList<>();
        for (int num : A) {
            strNum.add(String.valueOf(num));
        }

        // sorting using custom comparator
        // reversing the normal operation of sorting by reversing the flow in function
        // body
        Collections.sort(strNum, (X, Y) -> (Y + X).compareTo(X + Y));

        // base condition
        if (strNum.get(0).equals("0")) {
            // all digits are 0
            return "0";
        }

        // converting to final string
        StringBuilder resultant = new StringBuilder();
        for (String str : strNum) {
            resultant.append(str);
        }

        return resultant.toString();

    }
}
