package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MooreVotingAlgo {
    public int repeatedNumber1(final ArrayList<Integer> A) {
        // getting the size of array
        int N = A.size();

        // base case
        if (N == 1) {
            return A.get(0);
        }

        // used to find majority element i.e element with occurence in list > N/2
        // can be 0 or 1

        int candidate = -1, count = 0;

        // finding potential candidate
        for (int num : A) {
            if (num == candidate) {
                count++;
            } else if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                count--;
            }
        }

        // verifying that potential candidate
        count = 0;
        for (int num : A) {
            if (num == candidate) {
                count++;
            }
        }

        // checking its occurrence
        if (count > N / 2) {
            return candidate;
        }

        return -1;

    }

    // extended version
    // N / 3 occurrence
    public int repeatedNumber2(final ArrayList<Integer> B) {
        // getting the size of given arraylist
        int N = B.size();

        // as N / 3 hence majority no. of elements can be either 0, 1 or 2

        // base case
        if (N == 1) {
            return B.get(0);
        }

        int candidate1 = -1, candidate2 = -1;
        int count1 = 0, count2 = 0;

        // finding potential candidates
        for (int num : B) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }

        }

        // verifying those potential candidates
        count1 = count2 = 0;
        for (int num : B) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // checking it's occurrence
        if (count1 > N / 3) {
            return candidate1;
        } else if (count2 > N / 3) {
            return candidate2;
        }

        return -1; // no majority elements found

    }
}
