package Stackque;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    // using queue to implement stack
    private Queue<Integer> queue;

    public ImplementStackUsingQueue() {
        queue = new LinkedList<>();
    }

    // adding element to the stack
    public void push(int x) {
        // adding element to queue
        queue.add(x);

        // rotating the queue
        int rotations = queue.size() - 1;
        for (int i = 0; i < rotations; i++) {
            queue.add(queue.remove()); // moving the element added last to first for LIFO
        }
    }

    // removing the element from the stack
    public int pop() {
        // checking if the stack is empty or not
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }

        return queue.remove();
    }

    // return the topmost element from the stack
    public int top() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }

        return queue.peek();
    }

    // getting the size of the stack
    public int size() {
        return queue.size();
    }
}
