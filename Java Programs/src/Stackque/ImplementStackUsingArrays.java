package Stackque;

public class ImplementStackUsingArrays {
    // creating array for elements to be stored inside stack
    private int[] arr;
    private int top; // for maintaining the topmost element

    public ImplementStackUsingArrays() {
        // initializing the array for default stack size
        arr = new int[1000];
        top = -1; // initially the stack is empty
    }

    public void push(int x) {
        // if stack is full
        if (top == arr.length - 1) {
            throw new RuntimeException("Stack Overflow!");
        }

        arr[++top] = x;
    }

    public int pop() {
        // is stack is empty
        if (top == -1) {
            throw new RuntimeException("Stack is empty!");
        }

        return arr[top--];
    }

    public int top() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty!");
        }

        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
