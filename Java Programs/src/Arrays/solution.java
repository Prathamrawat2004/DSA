package Arrays;
import java.util.*;

public class solution{
    public List<Integer> occurences(ArrayList<Integer> A){
        // resultant list
        List<Integer> result = new ArrayList<>();

        // base condition
        if(A.isEmpty()){
            return result;
        }

        // sorting the given list to ensure smaller element's freqencies first
        Collections.sort(A);

        // initializing hashmap to store the frequencies
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // storing the frequencies
        for(int num: A){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // initializing hashset to maintain distinct order
        HashSet<Integer> set = new HashSet<>();
        for(int num: A){
            if(!set.contains(num)){
                // add it's value
                result.add(freqMap.get(num));
                set.add(num);
            }
        }



        return result;

    }
}
