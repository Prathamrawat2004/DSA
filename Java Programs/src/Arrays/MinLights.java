package Arrays;

import java.util.ArrayList;

public class MinLights {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size(); // size of corridor with lights
        int lightsOn = 0;
        int i = 0;

        while (i < n) {
            int lastPosition = -1;

            // finding the farthest light which can light up the current position
            for (int j = Math.min(i + B - 1, n - 1); j >= Math.max(i - B + 1, 0); j--) {
                if (A.get(j) == 1) {
                    lastPosition = j;
                    break;
                }
            }

            // if no light found
            if (lastPosition == -1) {
                return -1;
            }

            lightsOn++;

            // incrementing the position of i
            i = lastPosition + B;
        }

        return lightsOn;

    }
}
