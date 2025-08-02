package Stackque;

import java.util.*;

public class ImplementQueueUsingStack {
    // using two stacks to implement a queue
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    // inititalizing the queue
    public ImplementQueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // adding element to the queue
    public void enqueue(int x) {
        // push to stack1
        stack1.push(x);
    }

    // removing element from the queue
    public int dequeue() {
        if (IsEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }

        // shifting element from stack1 to stack2
        shiftStacks();
        return stack2.pop();
    }

    // getting the top element from the queue
    public int front() {
        if (IsEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }

        // shifting element from stack1 to stack2
        shiftStacks();
        return stack2.peek();
    }

    // function to get the size of queue
    public int getSize() {
        return stack1.size() + stack2.size();
    }

    // function to check if stack is empty or not
    public boolean IsEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // helper function to shift the elements of stack 1 to stack 2
    public void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
