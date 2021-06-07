package dev.kartikbhalla;

import java.util.Arrays;

public class Queue {

    /* Usage Example
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
     */

    protected int[] array;
    protected int front, rear;


    Queue(int size) {
        array = new int[size];
        front = rear = -1;
    }

    public void enqueue(int element) {
        if (isEmpty())
            front = rear = 0;
        else if (isFull()) throw new IllegalStateException();
        else rear++;

        array[rear] = element;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        else if (front == rear) {
            int element = array[front];
            front = rear = -1;
            return element;
        }

        return array[front++];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();

        return array[front];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return rear == this.array.length - 1;
    }

    @Override
    public String toString() {
        int[] array;

        if (isEmpty()) array = new int[0];
        else array = Arrays.copyOfRange(this.array, front, rear + 1);

        return Arrays.toString(array);
    }

}
