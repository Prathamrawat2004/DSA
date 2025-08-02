package Stackque;

public class ImplementQueueUsingArrays {
    // we are doing a circular queue implementation
    // this is usually done to use the empty spaces created by removing from the
    // front
    // if implemented using linear array, even if we have space it would not allow
    // us to add

    private int[] arr;
    private int front;
    private int end; // or rear
    private int size;

    // constructor
    public ImplementQueueUsingArrays() {
        arr = new int[1000];
        front = 0;
        end = -1;
        size = 0;
    }

    public ImplementQueueUsingArrays(int capacity) {
        arr = new int[capacity];
        front = 0;
        end = -1;
        size = 0;
    }

    // adding element to array
    public void enqueue(int x) {
        // check if the array is full
        if (isFull()) {
            throw new RuntimeException("Queue is Full!");
        }

        end = (end + 1) % arr.length;
        arr[end] = x;
        size++;
    }

    // removing element from the queue
    public int dequeue() {
        // check if the queue is empty
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }

        int val = arr[front];
        front = (front + 1) % arr.length;
        size--;

        return val;
    }

    // front element without removal
    public int peek() {
        // check if the queue is empty
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }

        return arr[front];
    }

    // checking if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // checking if the queue is full
    public boolean isFull() {
        return size == arr.length;
    }

}
