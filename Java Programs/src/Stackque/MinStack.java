package Stackque;

import java.util.*;

public class MinStack {
    // declaring main and min stacks
    Stack<Integer> stack;
    Stack<Integer> minStack;

    // constructor function
    public MinStack() {
        // initializing the above stacks
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // defining stack operations

    // Push operation
    public void Push(int x) {
        stack.push(x); // pushing to main stack

        // if minStack is empty or x is smaller than the topmost element
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Pop operation
    public void Pop() {
        if (stack.isEmpty()) {
            return;
        }

        int popped = stack.pop();

        // if similar element inside the min stack
        if (!minStack.isEmpty() && popped == minStack.peek()) {
            minStack.pop();
        }
    }

    // Top or Peek operation
    public int Top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    // min element removal operation
    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
