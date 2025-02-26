package RECURSION.Backtracking;

import java.util.ArrayList;

public class LetterCombinations {
    // only printing the permutations
    static void pad(String p, String up) {
        // base condition
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    // printing the arraylist: part 1
    static void padList(String p, String up, ArrayList<String> finalList) {
        // Base condition
        if (up.isEmpty()) {
            finalList.add(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            padList(p + ch, up.substring(1), finalList);
        }
    }

    // printing the arraylist: part 2
    static ArrayList<String> padList2(String p, String up) {
        // Base condition
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> finalList = new ArrayList<>();

        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            finalList.addAll(padList2(p + ch, up.substring(1)));
        }

        return finalList;
    }

    // returning the total count of all the combinations
    static int padCount(String p, String up) {
        // Base condition
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;

        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }

        return count;

    }

    public static void main(String[] args) {
        // String telephone = "12";
        // pad("", "12");
        // ArrayList<String> req = new ArrayList<>();
        // padList("", "12", req);
        // System.out.println(req);
    }
}
