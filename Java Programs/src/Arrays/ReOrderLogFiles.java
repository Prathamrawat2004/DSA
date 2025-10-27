package Arrays;
// revisions = 1
import java.util.ArrayList;
import java.util.Collections;

public class ReOrderLogFiles {
    public ArrayList<String> reorderLogs(ArrayList<String> A) {
        // creating the letter and digit logs arrays
        ArrayList<String> letterLogs = new ArrayList<>();
        ArrayList<String> digitLogs = new ArrayList<>();

        // seperating the digit and letter logs
        for (String log : A) {
            // splitting each log in terms of identifier & content
            // split in (limit - 1) times
            String[] split = log.split("-", 2);

            // getting the identifier
            String id = split[0];

            // getting the content
            String content = split[1];

            if (Character.isDigit(content.trim().charAt(0))) {
                // adding to digitlogs
                digitLogs.add(log);
            } else {
                // adding to letterlogs
                letterLogs.add(log);
            }
        }

        // sorting the letter logs lexicographically
        Collections.sort(letterLogs, (log1, log2) -> {
            // getting the identifier & contents of both logs
            String[] split1 = log1.split("-", 2);
            String[] split2 = log2.split("-", 2);

            String id1 = split1[0], content1 = split1[1];
            String id2 = split2[0], content2 = split2[1];

            // comparing on the basis of content
            int cmp = content1.compareTo(content2);

            if (cmp != 0) {
                // no same content
                return cmp;
            }

            return id1.compareTo(id2);

        });

        // combining the logs
        ArrayList<String> resultLogs = new ArrayList<>();
        resultLogs.addAll(letterLogs);
        resultLogs.addAll(digitLogs);

        return resultLogs;

    }
}
