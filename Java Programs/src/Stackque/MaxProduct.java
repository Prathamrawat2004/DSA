package Stackque;

import java.util.*;

public class MaxProduct {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        long mod = 1000000007;

        // base condition
        if (n < 3) {
            return 0; // min length should be 3
        }

        ArrayList<Integer> leftSpecial = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> rightSpecial = new ArrayList<>(Collections.nCopies(n, 0));

        Stack<Integer> stack = new Stack<>();

        // finding the left special values
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)){
                stack.pop();
            }

            if(!stack.isEmpty()){
                leftSpecial.set(i, stack.peek());
            }

            stack.push(i);
        }

        // clearing the stack for right special
        stack.clear();

        // finding the right special values
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && A.get(stack.peek()) <= A.get(i)){
                stack.pop();
            }

            if(!stack.isEmpty()){
                leftSpecial.set(i, stack.peek());
            }

            stack.push(i);
        }

        // finding the maxproduct
        long maxproduct = 0;
        for(int i = 0; i < n; i++){
            long product = (long) leftSpecial.get(i) * rightSpecial.get(i);
            maxproduct = Math.max(maxproduct, product);
        }

        return (int) (maxproduct % mod);



    }
}
