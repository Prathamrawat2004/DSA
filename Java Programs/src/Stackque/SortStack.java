package Stackque;

import java.util.Stack;

public class SortStack {
    public void sortStack(Stack<Integer> st) {
        if(!st.isEmpty()){
            int top = st.pop();
            sortStack(st);
            insertInStack(st, top);
        }
    }

    // helper function to insert inside a stack in descending order
    public void insertInStack(Stack<Integer> stack, int value){
        if(stack.isEmpty() || stack.peek() <= value){
            stack.push(value);
        }else{
            // remove the top 
            int top = stack.pop();

            // insert the current value
            insertInStack(stack, value);

            // now add the top over it to maintain descending
            stack.push(top);
        }
    }
}
