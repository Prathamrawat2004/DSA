package Strings;
// revisions = 1
public class CountAndSay {
    public String countAndSay(int A) {
        // base condition
        if (A <= 0) {
            return "";
        }

        String result = "1";
        for (int i = 2; i <= A; i++) {
            result = generateSequence(result);
        }

        return result;

    }

    // helper function to generate the sequence
    public String generateSequence(String sequence) {
        StringBuilder nextSeq = new StringBuilder();
        int count = 1;
        char prevChar = sequence.charAt(0);

        for (int i = 1; i < sequence.length(); i++) {
            char currentChar = sequence.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                nextSeq.append(count).append(prevChar);

                // resetting the count
                count = 1;

                prevChar = currentChar;
            }

        }

        // adding the last character
        nextSeq.append(count).append(prevChar);

        return nextSeq.toString();
    }
}
