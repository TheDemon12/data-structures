package dev.kartikbhalla;

import java.util.ArrayList;
import java.util.Arrays;

public class  CircularQueue extends Queue {

    /* Usage Example
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();
        queue.enqueue(6);
        System.out.println(queue);
     */

    CircularQueue(int size) {
        super(size);
    }

    @Override
    public void enqueue(int element) {
        if (isEmpty())
            front = rear = 0;
        else if (isFull()) throw new IllegalStateException();
        else rear = (rear + 1) % array.length;

        array[rear] = element;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        else if (front == rear) {
            int element = array[front];
            front = rear = -1;
            return element;
        }

        var element = array[front];
        front = (front + 1) % array.length;
        return element;
    }

    @Override
    public boolean isFull() {
        return front == (rear + 1) % array.length;
    }

    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = front; ; i = (i + 1) % array.length) {
            list.add(array[i]);
            if (i == rear) break;

        }

        return Arrays.toString(list.toArray());
    }
}
