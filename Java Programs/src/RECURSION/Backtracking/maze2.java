package RECURSION.Backtracking;

import java.util.ArrayList;

public class maze2 {
    static void path(String p, int r, int c) {
        // base condition
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        // if both row and column are greater than 1 then only call recursion
        if (r > 1) {
            path(p + 'D', r - 1, c);

        }

        if (c > 1) {
            path(p + 'R', r, c - 1);

        }

    }

    // returning the arraylist
    static ArrayList<String> pathList(String p, int r, int c){
        // base condition
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        // creating final list
        ArrayList<String> finalList = new ArrayList<>();

        if (r > 1) {
            finalList.addAll(pathList(p + 'D', r - 1, c));

        }

        if (c > 1) {
            finalList.addAll(pathList(p + 'R', r, c-1));
        }

        return finalList;

    }

    // including diagonal elements also
    static ArrayList<String> pathDiag(String p, int r, int c){
        // base condition
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        // adding to final list
        ArrayList<String> finalList = new ArrayList<>();

        // for moving down
        if(r > 1){
            finalList.addAll(pathDiag(p + 'V', r - 1, c));
        }

        // for moving right
        if(c > 1){
            finalList.addAll(pathDiag(p + 'H', r, c - 1));
        }

        // for moving diagonally
        if(r > 1 && c > 1){
            finalList.addAll(pathDiag(p + 'D', r - 1, c - 1));
        }

        return finalList;

    }
}
