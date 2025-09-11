package InfosysExtraProblems;

public class ExactPower {
    // brute force
    public boolean isPower(int x, long y) {
        // base condtion
        if (x == 1) {
            return (y == 1);
        }

        long pow = 1;
        while (pow < y) {
            pow = pow * x;
        }

        return pow == y;
    }

    

    // optimized approach
    public boolean isPower2(int x, long y) {
        // base condition
        if (x == 1) {
            return (y == 1);
        }

        double res = Math.log(y) / Math.log(x);

        // checking if its integer (exact power)
        return res == Math.floor(res);
    }
}
