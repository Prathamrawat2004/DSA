package InfosysExtraProblems;

import java.util.HashSet;

public class CommonDivisors {
    public int countCommonDivisors(int a, int b){
        // creating hashsets for two integers
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        getDivisors(setA, a);
        getDivisors(setB, b);

        // Update setA so it contains only elements that are also in setB
        setA.retainAll(setB); 

        return setA.size();
    }

    // function to find divisors
    public void getDivisors(HashSet<Integer> set, int a){
        for(int i = 1; i <= Math.sqrt(a); i++){
            if(a % i == 0){
                set.add(i);

                if(i != a / i){
                    set.add(a / i);
                }
            }
        }
    }
}
